package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;

import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 16.07.2015.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws OrderException;
    boolean registerClient(String name, String surname, String phone, String address, double sum, Date dateOrder) throws OrderException;
    List showClientsByPortion(int portionSize);
    List showClientsByPortionFrom(int from, int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
    Client findByPhoneNum(String phoneNum);
}
