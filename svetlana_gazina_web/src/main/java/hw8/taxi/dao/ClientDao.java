package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sveta on 8/13/2015.
 */
@Repository
public interface ClientDao {
    Long create(Client client);
    List showClientsByPortion(int portionSize);
    Client read(Long ig);
    boolean update(Client client);
    boolean delete(Client client);
    Client searchByLogin(String name);
    List findAll();
    public List showClientsGtSum(int sum);
    public List showClientsLastMonth();

}
