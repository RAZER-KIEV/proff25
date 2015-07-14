package scrum.dao;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by storo_000 on 14.07.2015.
 */
public class DriverDaoImpl implements DriverDao {

    //@Autowired
    private SessionFactory factory;


    @Override
    public Long create(Driver driver) {
        return null;
    }

    @Override
    public Driver get(Long id) {
        return null;
    }

    @Override
    public boolean update(Driver driver) {
        return false;
    }

    @Override
    public boolean delete(Driver driver) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }
}
