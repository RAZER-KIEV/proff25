package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.dao.ClientDaoImpl;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sveta on 8/11/2015.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        Client client = new Client(name,surname,phone,address);
        clientDao.create(client);
        return false;
    }

    @Override
    public List showClientsByPortion(int portionSize) {
        return clientDao.showClientsByPortion(portionSize);
    }

    @Override
    public List showClientsGtSum(int sum) {
        return clientDao.showClientsGtSum(sum);
    }

    @Override
    public List showClientsLastMonth() {
        return clientDao.showClientsLastMonth();
    }
}
