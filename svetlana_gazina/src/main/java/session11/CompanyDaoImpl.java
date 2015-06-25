package session11;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Sveta on 6/23/2015.
 */
public class CompanyDaoImpl implements CompanyDao {
    private SessionFactory factory;

    public CompanyDaoImpl() {
    }

    @Override
    public List<String> CompaniesWithMoThanEmp(Long num) {
        Session session = factory.openSession();
        Query query = session.createQuery("select c.name, count (c.name) from session11.Company c join c.employees p group by c.name having count(c.name) >:num");
        query.setParameter("num", num);
//        query.setParameter("name")



        return query.list();

    }

    public CompanyDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Company company) {
        return null;
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public Company read(Long id) {
        return null;
    }

    @Override
    public void delete(Company company) {

    }

    @Override
    public List<Company> findAll() {
        return null;
    }

}
