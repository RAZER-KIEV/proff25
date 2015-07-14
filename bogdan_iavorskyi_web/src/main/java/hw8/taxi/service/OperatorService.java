package hw8.taxi.service;

import hw8.taxi.domain.Operator;

public interface OperatorService {
    Operator read(String login);
    Long getIdByLogin(String login);
    String getLoginById(Long id);
}
