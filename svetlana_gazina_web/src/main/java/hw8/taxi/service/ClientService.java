package hw8.taxi.service;

import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Sveta on 8/11/2015.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws OrderException;
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
}
