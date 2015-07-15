package hw8.taxi.dao;

import hw8.taxi.domain.Order;

import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
public interface OrderDao {
    Long create(Order operator);
    Order read(Long ig);
    boolean update(Order operator);
    boolean delete(Order operator);
    Order searchByLogin(String login);
    List findAll();

}
