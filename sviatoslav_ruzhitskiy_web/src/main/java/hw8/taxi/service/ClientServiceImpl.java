package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientDao clientDao;

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        Client client = new Client(name,surname,phone,address);
       if(!(clientDao.create(client).equals(null))){
        return true;
       }
        return false;
    }

    @Override
    public List showClientsByPortion(int portionSize) {
        return  clientDao.showClientsByPortion(portionSize);
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
