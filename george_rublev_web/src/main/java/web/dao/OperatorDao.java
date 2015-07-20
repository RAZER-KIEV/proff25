package web.dao;

import web.domain.Operator;

import java.util.List;

/**
 * Created by george on 16.07.15.
 */
public interface OperatorDao {
    void addOperator(Operator operator);
    Operator findOperatorByName(String name);
    void removeOperator(Integer id);
    List listOperator();
}
