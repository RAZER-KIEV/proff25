package scrum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scrum.dao.TaxiDao;
import scrum.dao.UserDao;
import scrum.dao.UserDaoImpl;
import scrum.domain.User;

import java.util.List;

/**
 * Created by HP on 14.07.2015.
 */
@Service
@Transactional
public class ServiceTaxiImpl implements TaxiService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TaxiDao taxiDao;

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List getUserList() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public User read(Long id) {
        return null;
    }

    @Override
    public Long create(User user) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

 //   @Override
 //   public Long create(Taxi taxi) {
 //       return null;
 //   }
}
