package lection06.dao;

import lection06.domain.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonDAOImpl implements PersonDAO {
    @Autowired
    private SessionFactory factory;

    public PersonDAOImpl(){

    }

    public PersonDAOImpl(SessionFactory sessionFactory){
        factory = sessionFactory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    @Override
    public Long create(Person person) {
        return null;
    }

    @Override
    public Person read(Long id) {
        return null;
    }

    @Override
    public boolean update(Person person) {
        return false;
    }

    @Override
    public boolean delete(Person person) {
        return false;
    }

    @Override
    public List getPersonsPorced(int start, int size) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
