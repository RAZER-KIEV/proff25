package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.ClientException;

import java.util.List;

public interface ClientService {
    Client read(Long id);
    boolean createClient(String name, String surname, String phone, String address) throws ClientException;
    boolean createClientWithOperator(String operatorLogin, String name, String surname, String phone, String address) throws ClientException;
    List showAllClients();
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
}
