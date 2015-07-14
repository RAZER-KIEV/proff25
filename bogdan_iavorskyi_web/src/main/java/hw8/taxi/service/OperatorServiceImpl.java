package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    @Transactional(readOnly = true)
    @Override
    public Operator read(String login) {
        return operatorDao.read(login);
    }

    @Transactional(readOnly = true)
    @Override
    public Long getIdByLogin(String login) {
        return operatorDao.getIdByLogin(login);
    }

    @Transactional(readOnly = true)
    @Override
    public String getLoginById(Long id) {
        return operatorDao.getLoginById(id);
    }
}
