package hw7.springnotes.dao;


import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by ivan on 24.06.15.
 */
@Repository
public class NotebookDaoImpl implements NotebookDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        return (Long) factory.getCurrentSession().save(notebook);
    }

    @Override
    public Notebook read(Long id) {
        return (Notebook) factory.getCurrentSession().get(Notebook.class, id);
    }

    @Override
    public boolean update(Notebook notebook) {
        factory.getCurrentSession().update(notebook);
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        factory.getCurrentSession().delete(notebook);
        return true;
    }

    @Override
    public List<Notebook> findAll() {
        Query query = factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Notebook");
        return query.list();
    }

    public List<Notebook> getPortionOfNotebooks(int start, int portion) {
        if (start < 0 || portion <= 0 || portion <= start) {
            throw new IllegalArgumentException("ERROR: Input parameters 'start' and 'portion' must be correct.");
        }
        Query query = factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Notebook");
        query.setFirstResult(start);
        query.setMaxResults(portion);
        return query.list();
    }

    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        Query query = factory.getCurrentSession().createQuery("select n from hw7.springnotes.domain.Store s, hw7.springnotes.domain.Notebook n, " +
                "hw7.springnotes.domain.Vendor v where s.notebook=n and n.vendor=v and v.name=:name");
        return query.list();
    }

    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Query vendorQuery = factory.getCurrentSession().createQuery("select v from hw7.springnotes.domain.Store s, hw7.springnotes.domain.Notebook n," +
                " hw7.springnotes.domain.Vendor v where s.notebook=n and n.vendor=v");
        List vendorList = vendorQuery.list();
        Set<Vendor> vendorSet = new HashSet<>();
        for (Iterator iterator = vendorList.iterator(); iterator.hasNext(); ) {
            vendorSet.add((Vendor) iterator.next());
        }
        Map<Vendor, List<Notebook>> result = new HashMap<>();
        for (Vendor vendor : vendorSet) {
            Query notebooksQuery = factory.getCurrentSession().createQuery("select n from hw7.springnotes.domain.Store s join s.notebook n join n.vendor v where v.id=:id");
            notebooksQuery.setParameter("id", vendor.getId());
            result.put(vendor, notebooksQuery.list());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
