package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by just1ce on 16.07.2015.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
       return clientDao.create(new Client(new Date(),0L,address,surname,name,phone))!=null;
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
