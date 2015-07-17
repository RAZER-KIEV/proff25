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
    private SessionFactory factory;

    public ClientDaoImpl() {
    }

    public ClientDaoImpl(SessionFactory sessionFactory){
        this.factory = sessionFactory;
    }

    @Override
    public void addClient(Client client) {

    }

    @Override
    public List<Client> listClient() {
        Query query = factory.getCurrentSession().createQuery("from Client");
        return query.list();
    }

    @Override
    public void removeClient(Integer id) {

    }

    @Override
    public Client findClient(String name) {
        return null;
    }

    @Override
    public boolean cliendFind(String name) {
        return false;
    }
}
