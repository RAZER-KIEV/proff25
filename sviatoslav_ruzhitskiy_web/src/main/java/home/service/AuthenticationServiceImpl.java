package home.service;


import home.dao.AdminDao;
import home.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.List;

/**
 * Created by ПК on 11.07.2015.
 */

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {


   private Integer maxWrongPasses=5;

   @Autowired
   private AdminDao operatorDao;

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {

        Admin opr = operatorDao.searchByLogin(login);
        if (!opr.getIsBlocked() & opr.getPassword().equals(pass)) {
            return true;
        } else {
            opr.setWrongPass(opr.getWrongPass() + 1);
            if(opr.getWrongPass()>= maxWrongPasses) {
                opr.setIsBlocked(true);
                operatorDao.update(opr);
            }
            return false;
        }
    }
    @Override
    public Long create(Admin operator) {
        return operatorDao.create(operator);
    }

    @Override
    public Admin read(Long id) {
        return operatorDao.read(id);
    }

    @Override
    public boolean update(Admin operator) {
        return operatorDao.update(operator);
    }

    @Override
    public boolean delete(Admin operator) {
        return operatorDao.delete(operator);
    }

    @Override
    public Admin searchByLogin(String login) {
        return operatorDao.searchByLogin(login);
    }

    @Override
    public List findAll() {
        return operatorDao.findAll();
    }


}
