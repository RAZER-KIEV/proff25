package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;

import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long ig);
    boolean update(Client client);
    boolean delete(Client client);
    Client searchByLogin(String login);
    Long getDBSize();
    List findAll();
    List showClientsByPortion(int start, int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
    Object getCliensQuantity();
}
