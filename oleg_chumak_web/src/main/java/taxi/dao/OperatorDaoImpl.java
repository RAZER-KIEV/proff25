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

    public OperatorDaoImpl() {
    }

    public OperatorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public String create(Operator operator) {
        return (String) factory.getCurrentSession().save(operator);
    }

    @Override
    public Operator read(String login) {
        Query query = factory.getCurrentSession().createQuery("from Operator as o where o.login=:login");
        query.setParameter("login", login);
        return (Operator) query.uniqueResult();
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
    public List findAll() {
        return factory.getCurrentSession().createQuery("from Operator as oper").list();
    }

    @Override
    public boolean auth(String login, String password) {
        Query query = factory.getCurrentSession().createQuery("select count (*) from Operator as op where op.login=:login and op.password=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        Long result = (Long) query.uniqueResult();
        return result == 1 ? true : false;
    }

    @Override
    public boolean isLoginUnique(String login) {
        Query query = factory.getCurrentSession().createQuery("select count (*) from Operator as op where op.login=:login");
        query.setParameter("login", login);
        Long result = (Long) query.uniqueResult();
        return result == 1 ? false : true;
    }
}
