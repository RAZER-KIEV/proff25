package session12.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.Company;
import session11.Emploee;
import session12.util.HibernateUtil;

import java.util.Set;

/**
 * Created by RAZER on 23.06.2015.
 */
public class DaoCompanyImpl implements DaoCompany {
    private SessionFactory sessionFactory;
    public  DaoCompanyImpl(){
        this.sessionFactory = HibernateUtil.getInstance().getExistingSessionFactory();
    }
    public DaoCompanyImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Company company) {
        Session session = sessionFactory.openSession();
        //Long id = null;
        try {
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            //log.error("Exception: Not saved!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

    }

     @Override
    public void create(Emploee emploee) {
         Session session = sessionFactory.openSession();
         Long id = null;
         try {
             session.beginTransaction();
             id = (Long) session.save(emploee);
             session.getTransaction().commit();
         }catch (HibernateException hEx){
             System.out.println("Exception: Not saved!");
             //log.error("Exception: Not saved!  "+hEx);
             hEx.printStackTrace();
         }finally {
             if (session != null) {
                 session.close();
             }
         }

    }

    @Override
    public Set<Object[]> getEmploeesFromCompany(Company company) {
        Session session = sessionFactory.openSession();
        String companyName = company.getName();
        Query query = session.createQuery("FROM session11.Company c join c.emploees");
        //query.setParameter("company", company);
        Set<Object[]> resSet = (Set<Object[]>) query.list();
        return resSet;
    }

    @Override
    public Set<Emploee> getEmploeesFromAllCompanys() {

        return null;
    }
}
