package week6_lesson11.service;

import org.hibernate.SessionFactory;
import week6_lesson11.dao.CompanyDaoImpl;
import week6_lesson11.dao.EmployeeDaoImpl;
import week6_lesson11.domain.Company;
import week6_lesson11.domain.Employee;

/**
 * Created by HP on 30.06.2015.
 */
public class CompEmplServiceImpl implements CompEmplService {
    SessionFactory factory;
    public CompEmplServiceImpl() {
    }
    public CompEmplServiceImpl(SessionFactory fact) {
        factory=fact;
    }

    public void factoryClose(){
        factory.close();
    }
    @Override
    public Company readComp(Long id) {

        CompanyDaoImpl compDao = new CompanyDaoImpl();
        return compDao.read(id);
    }
    @Override
    public Employee readEmpl(Long id) {
        EmployeeDaoImpl emplDao = new EmployeeDaoImpl();
        return emplDao.read(id);
    }
}
