package taxi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.Client;
import taxi.domain.Operator;

import java.util.List;

/**
 * Created by GFalcon on 16.07.15.
 */
@Repository
public class OperatorDaoImpl implements OperatorDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public String create(Operator operator) {
        return (String)factory.getCurrentSession().save(operator);
    }

    @Override
    public Operator read(String login) {
        return (Operator)factory.getCurrentSession().get(Client.class, login);
    }

    @Override
    public boolean update(Operator operator) {
        factory.getCurrentSession().update(operator);
        return true;
    }

    @Override
    public boolean delete(Operator operator) {
        factory.getCurrentSession().delete(operator);
        return true;
    }

    @Override
    public List<Operator> findAll() {
        return factory.getCurrentSession().createQuery("from Operators as oper").list();
    }

    @Override
    public boolean auth(String login, String password) {
        Query query = factory.getCurrentSession().createQuery("select count (*) from Operators as op where op.login=:login and op.password=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        Long result = (Long) query.uniqueResult();
        return result == 1 ? true : false;
    }
}
