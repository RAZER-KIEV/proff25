package session11.dao;

import hw6.notes.dao.NotebookDao;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.domain.Company;
import session11.domain.Employee;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session11.dao
 */
public class EmployeeDaoImpl implements EmployeeDao{
    private static Logger log = Logger.getLogger(EmployeeDao.class);
    private SessionFactory factory;

    public EmployeeDaoImpl (SessionFactory factory){
        this.factory = factory;
    }



    public Long createEmployee(Employee empl){
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(empl);
            session.getTransaction().commit();
        } catch (HibernateException e){
//            log.error("Transaction failed");
            session.getTransaction().rollback();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public List<Employee> findEmpl( Company company){
        Session session = factory.openSession();
        Query query = session.createQuery("from EMPLOYEE E JOIN E.COMPANY C WHERE C.COMPANY =: comp");
        query.setParameter("comp", company);


        return query.list();
    }

    @Override
    public List<Object[][]> findAll(){
        Session session = factory.openSession();
        List<Object[][]> list =  session.createQuery("from EMPLOYEE").list();
        session.close();
        return list;

    }

    @Override
    public List<Object[][]> findBigCompany(){
        Session session = factory.openSession();
        List<Object[][]> list = session.createQuery("select c.name, count(c.name) as kol from company c group by c.name having kol>=2").list();
        return list;
//        select c.name, count (c.name) from Company c join c.persons p group by c.name having count(c.name) >:number
    }
}
