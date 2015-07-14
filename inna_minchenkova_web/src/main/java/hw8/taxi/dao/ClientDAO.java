package hw8.taxi.dao;

import hw8.taxi.domain.Client;

import java.util.List;

/**
 * Created by Vlad on 05.04.2015.
 */
public interface ClientDAO {
    public void createClient(Client client);

    public Client readClient(Long id);

    public Client readByName(String name);

    public void deleteClient(Client client);

    public void updateClient(Client client);

    public List showClientsByPortion(int portionSize);

    public List showClientsGtSum(int sum);

    public List showClientsLastMonth();
}
