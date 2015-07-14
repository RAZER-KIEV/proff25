package hw8.taxi.service;

import hw8.taxi.dao.OperatorDaoImpl;
import hw8.taxi.domain.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    private OperatorDaoImpl operatorDao;

    public OperatorServiceImpl() {
    }
    public OperatorServiceImpl(OperatorDaoImpl operatorDaoDao) {
        this.operatorDao = operatorDaoDao;
    }

    public OperatorDaoImpl getOperatorDao() {
        return operatorDao;
    }
    public void setOperatorDao(OperatorDaoImpl operatorDaoDao) {
        this.operatorDao = operatorDaoDao;
    }

    @Override
    public boolean createOperator(String identNum, String login, String pass, Date date, Date passDate, Integer countMiss, boolean isitBlock) {
        operatorDao.create(new Operator(identNum, login, pass, date, passDate,countMiss, isitBlock));
        return true;
    }
    @Override
    @Transactional(readOnly = true)
    public Operator getOperator(Long id) {
        return operatorDao.read(id);
    }
    @Override
    public void update(Operator operator) {
        operatorDao.update(operator);
    }
}
