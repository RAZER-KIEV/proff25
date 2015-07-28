package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.List;

/**
 * Created by storo_000 on 10.07.2015.
 */
public interface ClientService {
    Client getClient(Long id);
    Client getClientByName(String name, String surname);
    Client getClientByPhone(String phone);
    boolean createClient(String name, String surname, String phone, String address) throws ClientException;
    void updateClient(Client client, Long amount);
    List findAll();
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
}
