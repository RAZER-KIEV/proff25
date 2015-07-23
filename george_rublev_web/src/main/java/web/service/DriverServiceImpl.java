package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.ClientDao;
import web.dao.DriversDao;
import web.domain.Drivers;

import java.util.List;

/**
 * Created by george on 20.07.15.
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    private DriversDao driversDao;

    public DriverServiceImpl() {
    }

    public DriverServiceImpl(DriversDao driversDao) {
        this.driversDao = driversDao;
    }

    @Autowired
    public void setDriversDao(DriversDao driversDao) {
        this.driversDao = driversDao;
    }

    @Override
    public void addDrivers(Drivers drivers) {

    }

    @Override
    public List<Drivers> listDrivers() {
        return driversDao.listDrivers();
    }

    @Override
    public void removeDrivers(Integer id) {

    }

    @Override
    public Drivers findDrivers(String name) {
        return null;
    }
}
