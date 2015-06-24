package week6_lesson11.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import week6_lesson11.domain.Company;
import week6_lesson11.domain.Employee;
import week6_lesson11.util.HiberUtil;

import java.util.ArrayList;
import java.util.List;
/**
 TASK.1
 РЕализовать следующие функции
 -Получить всех сотрудников указанной Company
 -Получить сотрудников из всех компаний
 */
public class CompanyDaoImpl implements CompanyDao {
SessionFactory factory;
    public CompanyDaoImpl() {
    }
    public CompanyDaoImpl(SessionFactory fact) {
        factory=fact;
    }
    public void factoryClose(){
        factory.close();
    }
    @Override
    public List getEmplFromAllComp() {
        Session session =factory.openSession();
        List list = session.createQuery("from Company c join c.employees e").list();
        List <Employee> returnList = new ArrayList<>();
        for(Object object: list)
        {Object[] obj=(Object[])object;  Employee tempEmp = (Employee)obj[1]; returnList.add(tempEmp);}
        return  returnList;
    }

    @Override
    public Long create(Company company) {
        Session session = factory.openSession();
        Long id=null;
        try {
            session.beginTransaction();
            id = (Long) session.save(company);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return id;
    }
    @Override
    public Company read(Long id) {
        Session session = factory.openSession();
        try{
            return (Company)session.get(Company.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean update(Company company) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean delete(Company company) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(company);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
        return false;
    }
}