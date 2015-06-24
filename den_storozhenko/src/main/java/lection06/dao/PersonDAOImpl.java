package lection06.dao;

import lection06.domain.Person;
import org.hibernate.SessionFactory;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
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
