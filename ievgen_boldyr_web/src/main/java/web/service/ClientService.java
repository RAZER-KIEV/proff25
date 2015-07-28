package web.service;

import web.domain.Client;

import java.util.List;

/**
 * Created by george on 13.07.15.
 */
public interface ClientService {

    void addClient(Client client);

    List<Client> listClient();

    void removeClient(Long id);

    Client findClient(String name);

}
