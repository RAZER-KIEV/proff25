package hw8.taxi.service;

import hw8.taxi.dao.OperatorDaoImpl;
import hw8.taxi.domain.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private OperatorDaoImpl operatorDao;

    public AuthenticationServiceImpl() {
    }
    public AuthenticationServiceImpl(OperatorDaoImpl operatorDao) {
        this.operatorDao = operatorDao;
    }

    public OperatorDaoImpl getOperatorDao() {
        return operatorDao;
    }
    public void setOperatorDao(OperatorDaoImpl operatorDao) {
        this.operatorDao = operatorDao;
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
    @Override
    public boolean authorization(String log, String pass) {
        return operatorDao.authorization(log, pass);}
    @Override
    public List findAll(){
            return operatorDao.findAll();
        }
    @Override
    public List showAll(){
        return operatorDao.showAll();
    }
    }
