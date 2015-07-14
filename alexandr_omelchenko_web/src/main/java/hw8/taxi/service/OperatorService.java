package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import java.util.Date;

public interface OperatorService {
    boolean createOperator(String identNum, String login, String pass, Date date, Date passDate, Integer countMiss, boolean isitBlock);
    Operator getOperator(Long id);
    void update(Operator operator);
}
