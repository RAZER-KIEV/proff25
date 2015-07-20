package hw8.taxi.dao;

import hw8.taxi.UserRole;
import hw8.taxi.domain.Operator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by storo_000 on 09.07.2015.
 */
@Repository
public class OperatorDaoImpl implements OperatorDao {
    private static final int STEP_PORCED =10;
    @Autowired
    private SessionFactory factory;

    public OperatorDaoImpl() {
    }

    public OperatorDaoImpl(SessionFactory sessionFactory){
        this.factory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return factory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }



    @Override
    public Long create(Operator operator) {
        return (Long)factory.getCurrentSession().save(operator);
    }

    @Override
    public Operator read(Long id) {
        return (Operator)factory.getCurrentSession().get(Operator.class, id);
    }

    @Override
    public Operator getByLogin(String login) {
        return  (Operator)factory.getCurrentSession().createQuery("from Operator o where o.login='" + login + "'").uniqueResult();
    }

    @Override
    public Operator getByLoginPass(String login, String pass) {
        return  (Operator)factory.getCurrentSession().createQuery("from Operator o where o.login='"+login+"' and o.password='"+pass+"'").uniqueResult();
    }

    @Override
    public Long getLoginPass(String login, String pass) {
        Query query = factory.getCurrentSession().createQuery("from Operator o where o.login='"+login+"' and o.password='"+pass+"'");
        return ((Operator)query.uniqueResult()).getId();
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
    public boolean authenticate(String login, String password) {
        Query query = factory.getCurrentSession().createQuery("from Operator o where o.login=:login and o.password=:password");
        query.setParameter("login",login);
        query.setParameter("password", password);
        return !query.list().isEmpty();
    }

    @Override
    public boolean register(String login, String pass, String id) {
        if (getByLogin(login)!=null)
            return false;
        Long numb = (Long)factory.getCurrentSession().save(new Operator(id, login, pass));
        return (numb>0);
    }

    public Long getCount(){
        return (Long)factory.getCurrentSession().createQuery("select COUNT(o.id) from Operator o").uniqueResult();
    }

    @Override
    public List<Operator> getOperatorsPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("from Operator");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Operator> findAll() {
        List<Operator> operators = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            operators.addAll(getOperatorsPorced(i, STEP_PORCED));
        }
        return operators;
    }

    @Override
    public List<Operator> findUsers() {
        Query query = factory.getCurrentSession().createQuery("from Operator o where o.role=:role");
        query.setParameter("role", UserRole.USER);
        return query.list();
    }

}
