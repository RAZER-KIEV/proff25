package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jax on 21.06.15.
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl notebook;
    private Session session;
    public NotebookServiceImpl(){}
    public NotebookServiceImpl(NotebookDaoImpl notebook){
        this.notebook = notebook;
    }


    @Override
    public Long add(Notebook ntb) {
        return notebook.create(ntb);
    }

    @Override
    public List<Notebook> findAll() {
        return notebook.findAll();
    }

    @Override
    public void changePrice(long id, double price) {
        try {
 //           Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.id=id");
            Notebook ntb = (Notebook) notebook.read(id);
            ntb.setPrice(price);
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public void changeSerialVendor(long id, String serial, String vendor) {
        Notebook ntb =(Notebook) notebook.read(id);
        session.beginTransaction();
        ntb.setSerial("12312");
        ntb.setModel("233");
        session.update(ntb);
        session.getTransaction().commit();
    }

    @Override
    public boolean delete(long id) {
        Notebook ntb =(Notebook) notebook.read(id);
        session.beginTransaction();
        session.delete(ntb);
        session.getTransaction().commit();
        return false;
    }

    @Override
    public boolean deleteByModel(String model) {
        try {
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.model='"+model+"'");
            Notebook ntb = (Notebook) query;
            query.list();
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return null;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return null;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return null;
    }
}
