package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Vlad on 05.04.2015.
 */
@Repository
public class ClientDaoImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createClient(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public Client readClient(Long id) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public Client readByName(String name) {
        return (Client) sessionFactory.getCurrentSession().createCriteria(Client.class).add(Restrictions.eq("clientName", name)).uniqueResult();
    }

    @Override
    public void deleteClient(Client client) {
        sessionFactory.getCurrentSession().delete(client);
    }

    @Override
    public void updateClient(Client client) {
        sessionFactory.getCurrentSession().update(client);
    }

    @Override
    public List showClientsByPortion(int portionSize) {
        return sessionFactory.getCurrentSession().createCriteria(Client.class).setMaxResults(portionSize).list();
    }

    @Override
    public List showClientsGtSum(int sum) {
        return sessionFactory.getCurrentSession().createCriteria(Client.class).add(Restrictions.gt("clientAmount", sum)).list();
    }

    @Override
    public List showClientsLastMonth() {

        List<Client> clientList = sessionFactory.getCurrentSession().createCriteria(Client.class).list();
        List<Client> resultlist = new ArrayList<>();
        Calendar nowDate = new GregorianCalendar();
        for (Client a : clientList) {
            if (a.getClientDate().get(Calendar.MONTH) == nowDate.get(Calendar.MONTH)) {
                resultlist.add(a);
            }
        }
        return resultlist;
    }
}
