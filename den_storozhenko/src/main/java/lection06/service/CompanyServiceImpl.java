package lection06.service;

import lection06.dao.CompanyDAO;
import lection06.dao.CompanyDAOImpl;
import lection06.dao.PersonDAO;
import lection06.dao.PersonDAOImpl;
import lection06.domain.Company;
import lection06.domain.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private CompanyDAO companyDAO;

    public CompanyServiceImpl(){

    }

    public CompanyServiceImpl(SessionFactory factory){
        personDAO = new PersonDAOImpl(factory);
        companyDAO = new CompanyDAOImpl(factory);
    }

    public List<Company> findAll(){
        return companyDAO.findAll();
    }
    @Transactional(readOnly = true)
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
