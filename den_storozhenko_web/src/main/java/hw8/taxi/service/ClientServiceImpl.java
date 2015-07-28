package hw8.taxi.service;

import hw8.taxi.IsValid;
import hw8.taxi.dao.ClientDao;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    public ClientServiceImpl() {
    }

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClient(Long id) {
        return clientDao.read(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClientByName(String name, String surname) {
        return clientDao.readByName(name,surname);
    }

    @Override
    public Client getClientByPhone(String phone) {
        return clientDao.readByPhone(phone);
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        String err="";
        if (name.isEmpty() || surname.isEmpty() || phone.isEmpty() || address.isEmpty()){
            err+="All fields should not be empty.<br>";
        }
        if (!Character.isUpperCase(name.charAt(0)) || !Character.isUpperCase(surname.charAt(0))){
            err+="Name and surname must begin from a capital letter.<br>";
        }
        if (!IsValid.isValidPhone(phone)){
            err+="Phone must be in format \"381234567890\" and contains only digits.<br>";
        }
        if (!err.isEmpty()){
            throw new ClientException(err);
        }
        Long res = clientDao.create(new Client(name,surname,phone,address,0,null));
        return (res>0);
    }

    @Override
    public void updateClient(Client client, Long amount) {
        client.setDateLastOrder(new Date());
        client.setCash((int) (client.getCash() + amount));
        clientDao.update(client);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> showClientsByPortion(int portionSize) {
        return clientDao.showClientsByPortion(portionSize);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> showClientsGtSum(int sum) {
        return clientDao.showClientsGtSum(sum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> showClientsLastMonth() {
        return clientDao.showClientsLastMonth();
    }
}
