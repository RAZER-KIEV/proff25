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
    public void addOperator(Operator operator) {

    }

    @Override
    public Operator findOperatorByName(String name) {
        return (Operator) sessionFactory.getCurrentSession().createQuery("select o from operator o where o.login = name");
    }

    @Override
    public void removeOperator(Integer id) {

    }

    @Override
    public List listOperator() {
        Query query = sessionFactory.getCurrentSession().createQuery("from OPERATOR");
        return query.list();
    }
}
