package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 12.07.2015.
 */
public interface AuthenticationService {
    boolean createOperator(String identNum, String login, String pass, Date date, Date passDate, Integer countMiss, boolean isitBlock);
    Operator getOperator(Long id);
    void update(Operator operator);
    boolean authorization(String log, String pass);

    List findAll();

    List showAll();
}
