package hw8.taxi.dao;

import hw8.taxi.domain.Operator;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ПК on 14.07.2015.
 */

@Repository
public class OperatorDaoImpl implements OperatorDao {
    @Autowired
    private SessionFactory sessionFactory;

    public OperatorDaoImpl() {
    }

    @Override
    public Long create(Operator operator) {
        return (Long)sessionFactory.getCurrentSession().save(operator);
    }

    @Override
    public Operator read(Long id) {
        return (Operator)sessionFactory.getCurrentSession().get(Operator.class, id);
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
    public Operator searchByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Operator o where o.login=:login");
        query.setParameter("login",login);
        return (Operator)query.uniqueResult();
    }

    @Override
    public List findAll() {
        List<Operator> operators;
        Query query = sessionFactory.getCurrentSession().createQuery("from Operator");
        operators = query.list();
        return operators;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
