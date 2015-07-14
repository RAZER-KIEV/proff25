package hw8.taxi.dao;

import hw8.taxi.domain.Client;

import java.util.List;

/**
 * Created by storo_000 on 10.07.2015.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    Client readByName(String name, String surname);
    boolean update(Client client);
    boolean delete(Client client);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
    List showClientsByPortion(int portionSize);
    List getClientsPorced(int start, int size);
    List findAll();
}
