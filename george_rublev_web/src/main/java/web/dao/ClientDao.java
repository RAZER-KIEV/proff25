package web.dao;

import web.domain.Client;
import java.util.List;
/**
 * Created by george on 13.07.15.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete(Client client);
    List<Client> listClient();
    List<Client> findClientByName(String name);
    boolean cliendFind(String name);
}
