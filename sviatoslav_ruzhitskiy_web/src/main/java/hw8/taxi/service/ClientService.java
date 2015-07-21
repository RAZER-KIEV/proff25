package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by ПК on 14.07.2015.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws OrderException;
    Client findClientById(Long id);
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
    Long createClientsInDB(int quantity);

}
