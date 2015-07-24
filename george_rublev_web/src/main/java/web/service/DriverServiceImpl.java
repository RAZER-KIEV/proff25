package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DriversDao;
import web.domain.Drivers;

import java.util.List;

/**
 * Created by george on 20.07.15.
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriversDao driversDao;

    public DriverServiceImpl() {
    }

    public DriverServiceImpl(DriversDao driversDao) {
        this.driversDao = driversDao;
    }

    public void setDriversDao(DriversDao driversDao) {
        this.driversDao = driversDao;
    }

    @Override
    public void addDrivers(Drivers drivers) {
        driversDao.createDriver(drivers);
    }

    @Override
    public void removeDrivers(Integer id) {
        Drivers drv = driversDao.readDriver(Long.valueOf(id));
    }

    @Override
    public Drivers findDrivers(String name) {
        List<Drivers> drivers = driversDao.listDrivers();
        for (Drivers drv : drivers) {
            if (drv.getName().equals(name)) {
                return drv;
            }
        }
        return null;
    }

    @Override
    public List<Drivers> listDrivers() {
        return driversDao.listDrivers();
    }
}
