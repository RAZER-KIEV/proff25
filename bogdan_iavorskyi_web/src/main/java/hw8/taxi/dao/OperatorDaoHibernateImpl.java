package hw8.taxi.dao;

import hw8.taxi.domain.Operator;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperatorDaoHibernateImpl implements OperatorDao {

    @Autowired
    private SessionFactory factory;

    public OperatorDaoHibernateImpl() {
    }

    @Override
    public Long create(Operator operator) {
        return (Long) factory.getCurrentSession().save(operator);
    }

    @Override
    public Operator read(Long id) {
        return (Operator) factory.getCurrentSession().get(Operator.class, id);
    }

    @Override
    public String getLoginById(Long id) {
        Query query = factory.getCurrentSession().createQuery("select op.login from Operator as op where op.id=:id");
        query.setParameter("id", id);
        return (String) query.uniqueResult();
    }

    @Override
    public Operator read(String login) {
        Query query = factory.getCurrentSession().createQuery("from Operator as op where op.login=:login");
        query.setParameter("login", login);
        List list = query.list();
        return list.size() == 0 ? null : (Operator) list.get(0);
    }

    @Override
    public Long getIdByLogin(String login) {
        Query query = factory.getCurrentSession().createQuery("select op.id from Operator as op where op.login=:login");
        query.setParameter("login", login);

        return (Long) query.uniqueResult();
    }

    @Override
    public void update(Operator operator) {
        factory.getCurrentSession().update(operator);
    }

    @Override
    public void delete(Operator operator) {
        factory.getCurrentSession().delete(operator);
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
    public List listAll() {
        return factory.getCurrentSession().createQuery("from Operator as op").list();
    }
}
