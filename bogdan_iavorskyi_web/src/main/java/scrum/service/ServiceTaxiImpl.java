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
    //TAXI
    @Override
    @Transactional(readOnly = true)
    public Taxi readTaxi(Long id) {
        return taxiDao.read(id);
    }
    @Override
    public Long createTaxi(Taxi taxi) {
        return taxiDao.create(taxi);
    }
    @Override
    public boolean updateTaxi(Taxi taxi) {
        taxiDao.update(taxi);
        return true;
    }
    @Override
    public boolean deleteTaxi(Taxi taxi) {
        taxiDao.delete(taxi);
        return true;
    }
    @Override
    @Transactional(readOnly = true)
    public List getTaxiList() {
        return taxiDao.listAll();
    }
    //USER
    @Override
    @Transactional(readOnly = true)
    public User readUser(Long id) {
        userDao.read(id);
        return null;
    }
    @Override
    public Long createUser(User user) {
        return userDao.create(user);
    }
    @Override
    public boolean updateUser(User user) {
        userDao.update(user);
        return true;
    }
    @Override
    public boolean deleteUser(User user) {
        userDao.delete(user);
        return true;
    }
    @Override
    @Transactional(readOnly = true)
    public List getUserList() {
        return userDao.listAll();
    }
}