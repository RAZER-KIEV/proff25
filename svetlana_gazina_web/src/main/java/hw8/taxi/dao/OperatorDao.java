package hw8.taxi.dao;

import hw8.taxi.domain.Operator;

import java.util.List;

/**
 * Created by Sveta on 7/18/2015.
 */
public interface OperatorDao {
    Long create(Operator operator);
    Operator read(Long ig);
    boolean update(Operator operator);
    boolean delete(Operator operator);
    Operator searchByLogin(String login);
    List findAll();
}
