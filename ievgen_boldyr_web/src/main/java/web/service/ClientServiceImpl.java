package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.ClientDao;
import web.domain.Client;

import java.util.List;

/**
 * Created by george on 13.07.15.
 */
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

    @Transactional
    public void addClient(Client client) {
        clientDao.create(client);
    }

    @Transactional
    public List<Client> listClient() {
        return clientDao.listClient();
    }

    @Transactional
    public void removeClient(Long id) {
        clientDao.delete(clientDao.read(id));
    }

    @Transactional
    public Client findClient(String name) {
        List<Client> listClients = clientDao.findClientByName(name);
        for (Client client : listClients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }
}
