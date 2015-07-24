package web.service;

import web.domain.Operator;

import java.util.List;

/**
 * Created by george on 16.07.15.
 */
public interface OperatorService {
    public void addOperator(Operator operator);

    public List<Operator> listOperator();

    public void removeOperator(Integer id);

    public Operator findOperator(String name);
}
