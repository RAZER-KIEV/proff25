package session14.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import session14.domain.Company;
import session14.domain.Person;

import java.util.List;

/**
 * Created by oleg on 30.06.15.
 */
@Component
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    private SessionFactory factory;


    @Override
    public Long create(Company cmpn) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(cmpn);
    }

    @Override
    public Company read(Long ig) {
        return null;
    }

    @Override
    public boolean update(Company ntb) {
        return false;
    }

    @Override
    public boolean delete(Company ntb) {
        return false;
    }

    @Override
    public List<Company> findAll() {
        return null;
    }

    @Override
    public List<Person> findPersons(Company cmpn) {
        return null;
    }

    @Override
    public List<Person> findAllPersons() {
        return null;
    }

    @Override
    public void findCompaniesWithMoreThenTwoPersons() {

    }
}
