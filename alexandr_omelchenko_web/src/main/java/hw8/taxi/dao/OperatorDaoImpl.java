package hw8.taxi.dao;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;
import hw8.taxi.domain.Operator;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    public Long create(Operator operator) {
        return (Long) factory.getCurrentSession().save(operator);
    }
    @Override
    public Operator read(Long id) {
        return (Operator) factory.getCurrentSession().get(Operator.class, id);
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
        List<Operator> list;
        list = factory.getCurrentSession().createQuery("from hw8.taxi.domain.Operator").list();
        return list;
    }
    @Override
    public List showAll() {
        List<Operator> list;
        list = factory.getCurrentSession().createQuery("from hw8.taxi.domain.Operator").list();
        List<String> operators=new ArrayList<>();
        for(Operator op: list){operators.add(op.getLogin());}
        return operators;
    }
    @Override
    public boolean authorization(String login, String pass) {
        List<Operator> list;
        Query query = factory.getCurrentSession().createQuery("from hw8.taxi.domain.Operator where login=:loginok ");
        query.setParameter("loginok", login);
       // query.setParameter("password", pass);
        list=query.list();
        for(Operator op: list){
            if (op.getPass().equals(pass)) { op.setCountMiss(0);factory.getCurrentSession().update(op); ; return true;}
            else op.setCountMiss(op.getCountMiss()+1);
            factory.getCurrentSession().update(op);
        }
        return false;
    }
    }