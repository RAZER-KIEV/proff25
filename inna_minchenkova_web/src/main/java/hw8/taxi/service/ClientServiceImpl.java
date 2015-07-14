package hw8.taxi.service;

import hw8.taxi.dao.ClientDAO;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vlad on 06.04.2015.
 */

@Repository
@Transactional
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientDAO clientDAO;

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        clientDAO.createClient(new Client(name, surname, phone, 0, address));
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public Client readByName(String name) {
        return clientDAO.readByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List showClientsByPortion(int portionSize) {
        return clientDAO.showClientsByPortion(portionSize);
    }

    @Transactional(readOnly = true)
    @Override
    public List showClientsGtSum(int sum) {
        return clientDAO.showClientsGtSum(sum);
    }

    @Transactional(readOnly = true)
    @Override
    public List showClientsLastMonth() {
        return clientDAO.showClientsLastMonth();
    }
}
