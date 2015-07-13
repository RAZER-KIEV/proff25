package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.dao.ClientDaoImpl;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service ("clientServiceImpl")
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDaoImpl clientDao;

    public ClientServiceImpl() {
    }
    public ClientServiceImpl(ClientDaoImpl clientDao) {
        this.clientDao = clientDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }
    public void setClientDao(ClientDaoImpl clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClient(Long id) {
        return clientDao.read(id);
    }
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
         clientDao.create(new Client(name, surname, phone, address));
        return true;
    }
    @Override
    public boolean createClient(String name, String surname, String phone, String address, Double sum, Date date) {
        clientDao.create(new Client(name, surname, phone, address, sum, date));
        return true;
    }
    @Override
    public void updateDate(Client client) {
        client.setDateLastOrder(new Date());
        clientDao.update(client);
    }
    @Transactional(readOnly = true)
    @Override
    public List showClientsByPortion(int portionSize) {
        return null;
    }
    @Override
    @Transactional(readOnly = true)
    public List showClientsGtSum(int sum) {
        return null;
    }
    @Override
    @Transactional(readOnly = true)
    public List showClientsLastMonth() {
        return null;
    }
}
