package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

/**
 * Created by Sveta on 7/16/2015.
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private OperatorDao operatorDao;

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {

        Operator opr = operatorDao.searchByLogin(login);
        if (!opr.getIsBlocked() & opr.getPassword().equals(pass)) {
            return true;
        }else
            return false;
    }
}
