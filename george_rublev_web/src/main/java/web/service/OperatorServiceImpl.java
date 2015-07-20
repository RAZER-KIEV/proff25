package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.OperatorDao;
import web.domain.Operator;

//import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by george on 16.07.15.
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    public OperatorServiceImpl() {
    }

    public OperatorServiceImpl(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    @Transactional
    public void addOperator(Operator operator) {

    }

    @Transactional
    public List<Operator> listOperator() {
//        List<Operator> list;
//        list = (List<Operator>) operatorDao.listOperator();
//        for(Operator client : list){
//            if(client.getLogin().equals(name))return client;
//        }
        return null;
    }

    @Transactional
    public void removeOperator(Integer id) {

    }

    @Transactional
    public Operator findOperator(String name) {
        List<Operator> list;
        list = (List<Operator>) operatorDao.listOperator();
        for(Operator operator : list){
            if(operator.getLogin().equals(name))return operator;
        }
        return null;
    }
}
