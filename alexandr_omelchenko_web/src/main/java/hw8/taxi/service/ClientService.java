package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.Date;
import java.util.List;

/**
 * Created by HP on 12.07.2015.
 */
public interface ClientService {
    Client getClient(Long id);
    boolean createClient(String name, String surname, String phone, String address) throws ClientException;

    boolean createClient(String name, String surname, String phone, String address, Double sum, Date date);

    void updateDate(Client client);
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
}
