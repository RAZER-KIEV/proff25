package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
@Repository
public class ClientDaoImpl implements ClientDao{

    @Autowired
    private SessionFactory sessionFactory;

    public ClientDaoImpl() {
    }

    @Override
    public Long create(Client client) {
        return (Long)sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public Client read(Long id) {
        return (Client)sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        sessionFactory.getCurrentSession().update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        sessionFactory.getCurrentSession().delete(client);
        return true;
    }

    @Override
    public Client searchByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Client c where c.login=:login");
        query.setParameter("login",login);
        return (Client)query.uniqueResult();
    }

    @Override
    public Long getDBSize() {
        Long size = (Long) sessionFactory.getCurrentSession().createQuery("select COUNT(c.id) from Client c").uniqueResult();
        System.out.println("getDBSize: "+size);
        return size;
    }

    @Override
    public List findAll() {
        List<Client> operators;
        Query query = sessionFactory.getCurrentSession().createQuery("from Client");
        operators = query.list();
        return operators;
    }

    @Override
    public List showClientsByPortion(int start, int portionSize) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Client");
        query.setFirstResult(start);
        query.setMaxResults(portionSize);
        List<Client> clients = new ArrayList<>();
        clients = query.list();
          return clients;

    }

    @Override
    public List showClientsGtSum(int sum) {
        Double sumD=(double)sum;
        Session session = sessionFactory.openSession();
        Query query=session.createQuery("from Client c where c.summ>:sum");
        query.setParameter("sum", sumD);
        List<Client> clients= new ArrayList<>();
        clients = query.list();
                for(Client cl: clients){
                    System.out.println(cl);
                }
        return query.list();
    }

    @Override
    public List showClientsLastMonth() {
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.MONTH ,-1);
        Long millis = cal.getTimeInMillis();
        Date date = new Date(millis);
        System.out.println(date);
        Query query = sessionFactory.getCurrentSession().createQuery("from Client c where c.lastOrderDay>:date");
        query.setParameter("date",date);
        return query.list();
    }

    @Override
    public Long getCliensQuantity() {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT count (c.id) from Client c");
        return (Long)query.uniqueResult();
    }
}
