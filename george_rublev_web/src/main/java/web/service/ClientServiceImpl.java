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
    private ClientDao client;

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

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    @Transactional
    public List<Client> listClient() {
        return client.listClient();
    }

    @Transactional
    public void removeClient(Integer id) {

    }

    @Transactional
    public Client findClilent(String name) {
        List<Client> list;
        list = clientDao.listClient();
        for(Client client : list){
            if(client.getName().equals(name))return client;
        }
        return null;
    }
}
