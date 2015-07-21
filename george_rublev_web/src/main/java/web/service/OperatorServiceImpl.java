package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.OperatorDao;
import web.domain.Operator;

import java.util.List;

//import javax.transaction.Transactional;

/**
 * Created by george on 16.07.15.
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {


    private OperatorDao operatorDao;

    public OperatorServiceImpl() {
    }

    public OperatorServiceImpl(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    @Autowired
    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    @Transactional
    public void addOperator(Operator operator) {

    }

    @Transactional
    public List<Operator> listOperator() {
        return operatorDao.listOperator();
    }

    @Override
    public void removeOperator(Integer id) {

    }

    @Transactional
    public void removeOperator(Operator operator) {
            operatorDao.deleteOperator(operator);
    }

    @Transactional
    public Operator findOperator(String name) {
        List<Operator> list;
        list = (List<Operator>) operatorDao.listOperator();
        for (Operator operator : list) {
            if (operator.getLogin().equals(name)) return operator;
        }
        return null;
    }
}
