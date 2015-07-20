package web.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.domain.Operator;

import java.util.List;

/**
 * Created by george on 16.07.15.
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

    @Override
    public Long create(Operator operator) {
        return (Long)sessionFactory.getCurrentSession().save(operator);
    }

    @Override
    public Operator read(Long id){
        return (Operator)sessionFactory.getCurrentSession().get(Operator.class,id);
    }

    @Override
    public boolean update(Operator operator){
        sessionFactory.getCurrentSession().update(operator);
        return true;
    }

    @Override
    public boolean delete(Operator operator) {
        sessionFactory.getCurrentSession().delete(operator);
        return true;
    }

    @Override
    public Operator findOperatorByName(String name) {
        return (Operator) sessionFactory.getCurrentSession().createQuery("select o from web.domain.Operator o where o.login = name");
    }

    @Override
    public List listOperator() {
        Query query = sessionFactory.getCurrentSession().createQuery("from web.domain.Operator");
        return query.list();
    }
}
