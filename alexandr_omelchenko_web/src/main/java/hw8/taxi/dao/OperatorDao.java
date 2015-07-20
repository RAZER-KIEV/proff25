package hw8.taxi.dao;

import hw8.taxi.domain.Operator;
import java.util.List;

public interface OperatorDao {
    Long create(Operator operator);
    Operator read(Long id);
    boolean update(Operator operator);
    boolean delete(Operator operator);
    List findAll();

    List showAll();

    boolean authorization(String login, String pass);
}