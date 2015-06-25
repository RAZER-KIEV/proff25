package session11.dao;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.domain.Company;
import session11.domain.Employee;

import java.util.List;

/**
 * Created by ivan on 23.06.15.
 */
public class EmployeeDaoImpl implements EmployeeDao {

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
    public Long create(Employee employee) {
        checkFactory();
        Session session = factory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(employee);
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
    public Employee read(Long id) {
        checkFactory();
        Session session = factory.openSession();
        Employee employee = null;
        try {
            employee = (Employee)session.get(Company.class, id);
        } catch (HibernateException e){
            log.error("Cannot read company with id: "+id);
            e.printStackTrace();
        } finally {
            sessionCloser(session);
        }
        return employee;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    public List showAllwithCompanies(){
        checkFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from Employee e join e.company c");
        return query.list();
    }

    public static void main(String[] args) {
        Company c1 = new CompanyDaoImpl().read(4L);
//        Company c2 = new Company("bprs",10000D);
        Employee e1= new Employee("Revin",c1);
        System.out.println(new EmployeeDaoImpl().create(e1));
//      System.out.println(new EmployeeDaoImpl().read(3L));
    }
}
