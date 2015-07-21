package hw8.taxi.dao;

import hw8.taxi.domain.Operator;

import java.util.List;

/**
 * Created by storo_000 on 09.07.2015.
 */
public interface OperatorDao {
    Long create(Operator operator);
    Operator read(Long id);
    Operator getByLogin(String login);
    Operator getByLoginPass(String login, String pass);
    Long getLoginPass(String login, String pass);
    boolean update(Operator operator);
    boolean delete(Operator operator);
    boolean authenticate(String login, String password);
    boolean register(String login, String pass, String id);
    List getOperatorsPorced(int start, int size);
    List findAll();
}
