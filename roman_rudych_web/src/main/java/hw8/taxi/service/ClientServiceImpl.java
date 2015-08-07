package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 16.07.2015.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        Long id = clientDao.create(new Client(name, surname, phone, address));
        if(id>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean registerClient(String name, String surname, String phone, String address, double sum, Date dateOrder) throws OrderException {
        Long id = clientDao.create(new Client(name, surname, phone, address, sum, dateOrder));
        if(id>0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List showClientsByPortion(int portionSize) {
        return clientDao.findAll(0, portionSize);
    }

    @Override
    @Transactional(readOnly = true)
    public List showClientsByPortion(int from, int portionSize) {

        return clientDao.findAll(from, portionSize);
    }

    @Override
    @Transactional(readOnly = true)
    public List showClientsGtSum(int sum) {
        return clientDao.showClientsGtSum(sum);
    }

    @Override
    @Transactional(readOnly = true)
    public List showClientsLastMonth() {
        return clientDao.showClientsLastMonth();
    }

    @Override
    public Client findByPhoneNum(String phoneNum) {
        return clientDao.findByPhoneNum(phoneNum);
    }
}
