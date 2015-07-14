package comandWork.service;

/**
 * Created by RAZER on 14.07.2015.
 */

import comandWork.dao.TaxiDao;
import comandWork.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaxiServiceImpl implements TaxiService{
    //@Autowired
    private TaxiDao taxiDao;

    //@Autowired
    private UserDao userDao;

    @Override
    public boolean authenticate(String login, String pass)  {
        // User user = userDao.readByName(login);
        //if()



        return false;
    }

    @Override
    public List findAll() {
        return null;
    }
}