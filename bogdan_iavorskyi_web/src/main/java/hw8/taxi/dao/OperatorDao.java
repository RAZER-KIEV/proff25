package hw8.taxi.dao;

import hw8.taxi.domain.Operator;
import java.util.List;

public interface OperatorDao {
    Long create(Operator operator);
    Operator read(Long id);
    String getLoginById(Long id);
    Operator read(String login);
    Long getIdByLogin(String login);
    void update(Operator operator);
    void delete(Operator operator);
    boolean auth(String login, String password);
    List listAll();
}
