package hw8.taxi.dao;

import hw8.taxi.domain.Operator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.Date;
import java.util.List;

/**
 * Created by just1ce on 15.07.2015.
 */
@Repository
public class OperatorDaoImpl implements OperatorDao {
    @Autowired
    private SessionFactory sessionFactory;

    public OperatorDaoImpl() {
    }

    public OperatorDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Operator operator) {
        return (Long) sessionFactory.getCurrentSession().save(operator);
    }

    @Override
    public Operator read(Long id) {
        return (Operator) sessionFactory.getCurrentSession().get(Operator.class, id);
    }


    @Override
    public boolean update(Operator operator) {
        sessionFactory.getCurrentSession().update(operator);
        return true;
    }

    @Override
    public boolean delete(Operator operator) {
        sessionFactory.getCurrentSession().delete(operator);
        return true;
    }
    @Override
    public Operator getByLoginPass(String login, String pass) {
        return  (Operator) sessionFactory.getCurrentSession().createQuery("from Operator op where op.login='"+login+"' and op.pass='"+pass+"'").uniqueResult();
    }

    @Override
    public Long getLoginPass(String login, String pass) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Operator op where op.login='"+login+"' and op.pass='"+pass+"'");
        return ((Operator)query.uniqueResult()).getId();
    }
    @Override
    public Long getByLogin(String login) {
        Operator op =(Operator) sessionFactory.getCurrentSession().createQuery("from Operator op where op.login='" + login + "'").uniqueResult();
        if(op==null) return null;
        return op.getId();
    }

    @Override
    public boolean authenticate(String login, String password) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Operator op where op.login=:login and op.pass=:password");
        query.setParameter("login",login);
        query.setParameter("password", password);
        return !query.list().isEmpty();
    }

    @Override
    public boolean register(String login, String pass, Date date) {
        if (getByLogin(login)!=null)
            return false;
        Long id = (Long) sessionFactory.getCurrentSession().save(new Operator(login, pass, date));
        return (id>0);
    }


    @Override
    public List<Operator> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Operator");
        return query.list();
    }
}
