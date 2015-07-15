package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;

import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
public interface ClientDao {
    Long create(Client operator);
    Client read(Long ig);
    boolean update(Client operator);
    boolean delete(Client operator);
    Client searchByLogin(String login);
    List findAll();
}
