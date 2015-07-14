package scrum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scrum.dao.DriverDao;
import scrum.domain.Driver;

import java.util.List;

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
    @Transactional(readOnly = true)
    public List<Driver> findAll() {
        return driverDao.findAll();
    }
}
