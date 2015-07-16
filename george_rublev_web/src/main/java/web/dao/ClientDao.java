package web.dao;

import web.domain.Client;
import java.util.List;
/**
 * Created by george on 13.07.15.
 */
public interface ClientDao {
    void addClient(Client client);
    List<Client> listClient();
    void removeClient(Integer id);
    Client findClient(String name);
    boolean cliendFind(String name);
}
