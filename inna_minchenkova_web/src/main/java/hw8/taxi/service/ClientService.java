package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Vlad on 06.04.2015.
 */
public interface ClientService {
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException;

    public Client readByName(String name);

    public List showClientsByPortion(int portionSize);

    public List showClientsGtSum(int sum);

    public List showClientsLastMonth();
}
