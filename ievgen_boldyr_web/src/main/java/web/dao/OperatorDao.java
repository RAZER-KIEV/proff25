package web.dao;

import web.domain.Operator;

import java.util.List;

/**
 * Created by george on 16.07.15.
 */
public interface OperatorDao {
    Long create(Operator operator);

    Operator readOperator(Long id);

    boolean updateOperator(Operator operator);

    boolean deleteOperator(Operator operator);

    Operator findOperatorByName(String name);

    List listOperator();
}
