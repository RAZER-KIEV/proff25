package hw8.taxi.service;

import hw8.taxi.dao.DriverDao;
import hw8.taxi.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverDao driverDao;

    public DriverServiceImpl() {

    }

    public DriverServiceImpl(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    public DriverDao getDriverDao() {
        return driverDao;
    }

    public void setDriverDao(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    @Override
    public boolean authenticate(String phone, String password) {
        return driverDao.authenticate(phone,password);
    }

    @Override
    public Long create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverDao.read(id);
    }

    @Override
    public Driver getDriverByPhone(String phone) {
        return driverDao.readByPhone(phone);
    }
}
