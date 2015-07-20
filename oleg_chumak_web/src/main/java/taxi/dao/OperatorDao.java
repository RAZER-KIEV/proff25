package taxi.dao;

import taxi.domain.Operator;

import java.util.List;

/**
 * Created by GFalcon on 16.07.15.
 */
public interface OperatorDao {
    String create(Operator operator);

    Operator read(String login);

    boolean update(Operator operator);

    boolean delete(Operator operator);

    List<Operator> findAll();

    boolean auth(String login, String password);
}
