package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by ПК on 18.06.2015.
 */

@Repository
@Scope("prototype")
public class NotebookDaoImpl implements NotebookDao {

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory(){return sessionFactory;}

    public NotebookDaoImpl(){}
    public NotebookDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(ntb);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            log.error("Exception: Not saved!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = sessionFactory.openSession();
        Notebook nbk = null;
        try {
            nbk = (Notebook) session.get(Notebook.class,id);
        }catch (HibernateException hEx){
            System.out.println("Exception: Not readed!");
            log.error("Exception: Not readed!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        return nbk;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = sessionFactory.openSession();
        boolean upres = false;
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            upres = true;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            log.error("Exception: Not saved!  " + hEx);
            //hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return upres;
    }
    public void deleteAll(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook");
        List<Notebook> tmplst = query.list();
        for (Notebook ntb :tmplst){
            System.out.println(ntb);
            delete(ntb);
        }

    }
    @Override
    public boolean delete(Notebook ntb) {
        System.out.println(ntb);
        Long id = ntb.getId();
        String sid = ""+id;
        Session session = sessionFactory.openSession();
        boolean dlres = false;
        try {
            session.beginTransaction();
            session.delete(sid, ntb);                                             //Query query = session.createQuery("delete FRom Notebook n where n.id =:id");
            //query.setParameter("id", id);
            session.getTransaction().commit();
            dlres = true;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not deleted!");
            log.error("Exception: Not deleted!  " + hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return dlres;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook");
        return query.list();
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook n where n.model =:model");
        query.setParameter("model", model);
        // query.setFirstResult(1);
        // query.setMaxResults(2);
        return query.list();
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook n where n.vendor =:vendor");
        query.setParameter("vendor", vendor);
        // query.setFirstResult(1);
        //query.setMaxResults(2);
        return query.list();
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook n where n.manufacture_date>=:date AND n.price<=:price");
        query.setParameter("date", date);
        query.setParameter("price", price);
        //query.setFirstResult(1);
        // query.setMaxResults(2);
        return query.list();
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook n where n.manufacture_date>=:date AND n.price<=:priceTo AND n.price>=:priceFrom AND n.vendor=:vendor");
        query.setParameter("date", date);
        query.setParameter("priceFrom", priceFrom);
        query.setParameter("priceTo", priceTo);
        query.setParameter("vendor", vendor);
        //query.setFirstResult(1);
        //query.setMaxResults(2);
        return query.list();
    }
    public Date dateSet(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        Date date = cal.getTime();
        return date;
    }

    public Date dateSet(){
        Calendar cal = Calendar.getInstance();
        int year, month,day;
        Scanner scanner = new Scanner(System.in);
        System.out.println("DATE SET. Enter Year,(YYYY):");
        year = scanner.nextInt();
        System.out.println("Enter Month 0-11 , ( 0 - january....5 - june... 11 - december) :");
        month = scanner.nextInt();
        System.out.println("Enter day,(0-31): ");
        day = scanner.nextInt();
        cal.set(year, month, day);
        Date date = cal.getTime();
        return date;
    }

}
