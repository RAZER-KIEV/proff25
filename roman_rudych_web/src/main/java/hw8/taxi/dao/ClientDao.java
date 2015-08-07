package hw8.taxi.dao;

import hw8.taxi.domain.Client;

import java.util.List;

/**
 * Created by Роман on 16.07.2015.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete(Client client);
    List findAll();
    List findAll(int from, int portion);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
    Client findByPhoneNum(String phoneNum);
}
