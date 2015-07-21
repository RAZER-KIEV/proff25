package comandWork.service;

/**
 * Created by RAZER on 14.07.2015.
 */

import comandWork.dao.TaxiDao;
import comandWork.dao.UserDao;
import comandWork.domain.Taxi;
import comandWork.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaxiServiceImpl implements TaxiService{
    @Autowired
    private TaxiDao taxiDao;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean authenticate(String login, String pass)  {
         User user = userDao.readByName(login);
        if(user.getPassword().equals(pass)){
            return true;}
        return false;
    }

    @Override
    public List findAll() {
        return taxiDao.findAll();
    }
}