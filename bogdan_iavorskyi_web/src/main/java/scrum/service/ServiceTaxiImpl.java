package scrum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scrum.dao.TaxiDao;
import scrum.dao.UserDao;
import scrum.dao.UserDaoImpl;
import scrum.domain.Taxi;
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

    public ServiceTaxiImpl() {
    }
    public ServiceTaxiImpl(UserDao userDao, TaxiDao taxiDao) {
        this.userDao = userDao;
        this.taxiDao = taxiDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public TaxiDao getTaxiDao() {
        return taxiDao;
    }
    public void setTaxiDao(TaxiDao taxiDao) {
        this.taxiDao = taxiDao;
    }

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
    public List getTaxiList() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List getUserList() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public User readUser(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Taxi readTaxi(Long id) {
        return null;
    }

    @Override
    public Long create(Taxi taxi) {
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

}
