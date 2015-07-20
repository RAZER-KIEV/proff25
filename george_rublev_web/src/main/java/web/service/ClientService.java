package web.service;

import web.domain.Client;

import java.util.List;
/**
 * Created by george on 13.07.15.
 */
public interface ClientService {
    public void addClient(Client client);
    public List<Client> listClient();
    public void removeClient(Integer id);
    public Client findclilent(String name);
}
