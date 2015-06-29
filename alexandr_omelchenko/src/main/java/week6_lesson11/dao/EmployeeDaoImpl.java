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

public class EmployeeDaoImpl implements EmployeeDao {
    SessionFactory factory;
    public EmployeeDaoImpl() {
    }
    public EmployeeDaoImpl(SessionFactory fact) {
        factory=fact;
    }
public void factoryClose(){
    factory.close();
}
   // -Получить всех сотрудников указанной Company
    @Override
    public List getEmplFromCompany(Company company) {
        Session session = factory.openSession();
        List list = session.createQuery("from Company c join c.employees e  where c.name = '"+company.getName()+"'").list();
        List<Employee> returnList = new ArrayList<>();
        for(Object object: list)
        {Object[] obj=(Object[])object;  Employee tempEmp = (Employee)obj[1]; returnList.add(tempEmp);}
        return  returnList;
    }

    @Override
    public Long create(Employee employee) {
        Session session = factory.openSession();
        Long id=null;
        try {
            session.beginTransaction();
            id = (Long) session.save(employee);
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
    public Employee read(Long id) {
        Session session = factory.openSession();
        try{
            return (Employee)session.get(Employee.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean update(Employee employee) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(employee);
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
    public boolean delete(Employee employee) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(employee);
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