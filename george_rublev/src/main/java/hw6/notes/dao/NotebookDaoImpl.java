package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * Created by george on 19.06.15.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(String.valueOf(NotebookDaoImpl.class));
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory=factory;
    }

    Session session = null;

    @Override
    public Long create(Notebook ntb) {
        session = factory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(ntb);
            System.out.println(id);
            session.getTransaction().commit();
            return id;
        }catch(HibernateException ex){
            System.out.println("error when create notebook: "+ex);
        }finally{
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long ig) {
        session = factory.openSession();
        Notebook notebook = null;
        try{
            session.beginTransaction();
            notebook = (Notebook) session.get(Notebook.class, ig);
            System.out.println(notebook.getId() + "  " + notebook.getSerial());
            return notebook;
        }catch(HibernateException ex){
            System.out.println("error when read notebook: "+ex);
        }finally{
            session.close();
        }
        return notebook;
    }

    @Override
    public boolean update(Notebook ntb) {
        session = factory.openSession();
        Notebook notebook = null;
        try{
            session.beginTransaction();
            session.update(ntb);
//            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException ex){
            System.out.println("error when read notebook: "+ex);
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        session = factory.openSession();
        Notebook notebook = null;
        try{
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException ex){
            System.out.println("error when read notebook: "+ex);
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        session = factory.openSession();
        List<Notebook> data = (List<Notebook>) session.createQuery("from Notebook").list();
        return data;
    }

    @Override
    public List<Notebook> findByModel(String model) {
        session = factory.openSession();
        List<Notebook> data = (List<Notebook>) session.createFilter(Notebook.class,model);
        return data;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        session = factory.openSession();
        List<Notebook> data = (List<Notebook>) session.createFilter(Notebook.class,vendor);
        return data;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        session = factory.openSession();
        List<Notebook> data = (List<Notebook>) session.createFilter(Notebook.class, String.valueOf(price));
        List<Notebook> buf = new ArrayList<Notebook>();
        for(Notebook note : data){
            if(note.getManufactureDate().equals(date)){
                buf.add(note);
            }
        }
        return buf;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        session = factory.openSession();
        List<Notebook> data = (List<Notebook>) session.createFilter(Notebook.class, vendor);
        List<Notebook> buf = new ArrayList<Notebook>();
        for(Notebook note : data){
            if(priceFrom<note.getPrice()&&note.getPrice()<priceTo){
                if(note.getManufactureDate().equals(date)){
                    buf.add(note);
                }
            }
        }
        return buf;
    }


}
