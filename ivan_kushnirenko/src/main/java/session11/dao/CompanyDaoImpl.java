package session11.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.domain.Company;

import java.util.List;

/**
 * Created by ivan on 23.06.15.
 */
public class CompanyDaoImpl implements CompanyDao{

    private static Logger log = Logger.getLogger(Company.class);
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    private void checkFactory(){
        if (factory==null){
            factory=new session11.util.HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
    }

    private void sessionCloser(Session session){
        if(session!=null){
            session.close();
        }
    }

    @Override
    public Long create(Company company) {
        checkFactory();
        Session session = factory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(company);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("ERROR: cannot create new company.");
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
           sessionCloser(session);
        }
        return id;
    }

    @Override
    public Company read(Long id) {
        checkFactory();
        Session session = factory.openSession();
        Company company = null;
        try {
            company = (Company)session.get(Company.class, id);
        } catch (HibernateException e){
            log.error("Cannot read company with id: "+id);
            e.printStackTrace();
        } finally {
            sessionCloser(session);
        }
        return company;
    }

    public List<Company> findCompanyByName (String name) {
        checkFactory();
        Session session = factory.openSession();
        List<Company> companies = null;
        try {
            Query query = session.createQuery("from session11.domain.Company c where c.name=:name");
            query.setParameter("name", name);
            companies = query.list();
        } catch (HibernateException e) {
            log.error("ERROR: operation 'find by name' FAILED.", e);
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return companies;
    }

    @Override
    public List findCompanyEmployees(String companyName){
        checkFactory();
        Session session = factory.openSession();
        List res = null;
        try{
            Query query = session.createQuery("from Company c join c.employees e where c.name=:name");
            query.setParameter("name",companyName);
            res = query.list();
        } catch (HibernateException e){
            log.error("ERROR!");
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        return res;
    }

    @Override
    public boolean update(Company company) {
        return false;
    }

    @Override
    public boolean delete(Company company) {
        return false;
    }

    public static void main(String[] args) {
        Company c1= new Company("firma",300D);
        System.out.println(new CompanyDaoImpl().read(6L));
    }
}
