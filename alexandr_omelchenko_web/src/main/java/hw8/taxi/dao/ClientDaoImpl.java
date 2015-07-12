package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private SessionFactory factory;

    public ClientDaoImpl() {
    }
    public ClientDaoImpl(SessionFactory sessionFactory){
        this.factory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return factory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    @Override
    public Long create(Client client) {
        return (Long)factory.getCurrentSession().save(client);
    }
    @Override
    public Client read(Long id) {
        return (Client)factory.getCurrentSession().get(Client.class, id);
    }
    @Override
    public boolean update(Client client) {
        factory.getCurrentSession().update(client);
        return true;
    }
    @Override
    public boolean delete(Client client) {
        factory.getCurrentSession().delete(client);
        return true;
    }
    @Override
    public List findAll() {
        List<Client>list;
        list =factory.getCurrentSession().createQuery("from Client").list();
        return list;
    }

    @Override
    public List showClientsByPortion(int portionSize) {
        return null;
    }
    @Override
    public List showClientsGtSum(int sum) {
        return null;
    }
    @Override
    public List showClientsLastMonth() {
        return null;
    }
}