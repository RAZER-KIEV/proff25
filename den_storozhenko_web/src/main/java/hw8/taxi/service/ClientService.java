package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.List;

/**
 * Created by storo_000 on 10.07.2015.
 */
public interface ClientService {
    Client getClient(Long id);
    boolean createClient(String name, String surname, String phone, String address) throws ClientException;
    void updateDate(Client client);
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
}
