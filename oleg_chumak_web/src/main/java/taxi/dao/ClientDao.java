package taxi.dao;

import taxi.domain.Client;

import java.util.List;

/**
 * Created by oleg on 16.07.15.
 */
public interface ClientDao {
    List<Client> clientsPortinedByTen(Long numberOfPortion);
    List<Client> clientsMadeOrdersDuringLastMonth();
    List<Client> clientswithOrderAmountMoreThen(Long amount);
    String create(Client client);
    Client read(String name);
    boolean update(Client client);
    boolean delete(Client client);
    List<Client> findAll();
}
