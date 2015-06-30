package lection06.service;

import lection06.dao.CompanyDAOImpl;
import lection06.dao.PersonDAOImpl;
import lection06.domain.Company;
import lection06.domain.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CompanyServiceImpl implements CompanyService{
    //private PersonDAOImpl personDAO;
    @Autowired
    private CompanyDAOImpl companyDAO;

    public CompanyServiceImpl(){

    }

    public CompanyServiceImpl(SessionFactory factory){
        //personDAO = new PersonDAOImpl(factory);
        companyDAO = new CompanyDAOImpl(factory);
    }

    public List<Company> findAll(){
        return companyDAO.findAll();
    }

    @Override
    public List<Person> getEmploiesFromCompany(String name) {
        return companyDAO.getEmploiesFromCompany(name);
    }

    @Override
    public List<Person> getEmploiesFromAllCompanies() {
        return companyDAO.getEmploiesFromAllCompanies();
    }

    @Override
    public List<String> getCompaniesMoreThanPersons(Long count) {
        return companyDAO.getCompaniesMoreThanPersons(count);
    }
}
