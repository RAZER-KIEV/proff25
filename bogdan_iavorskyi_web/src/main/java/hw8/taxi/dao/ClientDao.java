package hw8.taxi.dao;

import hw8.taxi.domain.Client;

import java.util.List;

public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    void update(Client client);
    void delete(Client client);
    List listAll();
    List listClientsGtSum(int sum);
    List listClientsLastMonth();
    List listChunkOfClients(int startPoint, int chunkSize);
    long getListSize();
}
