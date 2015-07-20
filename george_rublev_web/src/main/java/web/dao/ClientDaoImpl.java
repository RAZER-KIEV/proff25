package web.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.domain.Client;

import java.util.List;

/**
 * Created by george on 15.07.15.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ClientDaoImpl() {
    }

    public ClientDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Client client) {
        return (Long)sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public Client read (Long id){
        return (Client)sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client){
        sessionFactory.getCurrentSession().update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        sessionFactory.getCurrentSession().delete(client);
        return true;
    }

    @Override
    public List<Client> listClient() {
        Query query = sessionFactory.getCurrentSession().createQuery("from web.domain.Client");
        return query.list();
    }

    @Override
    public List<Client> findClientByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select c from web.domain.Client c where c.name = name");
        query.setParameter(name,"name");
        return query.list();
    }

    @Override
    public boolean cliendFind(String name) {
        return false;
    }
}
