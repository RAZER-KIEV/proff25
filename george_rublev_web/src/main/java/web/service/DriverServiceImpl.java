package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.domain.Drivers;

import java.util.List;

/**
 * Created by george on 20.07.15.
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Override
    public void addDrivers(Drivers drivers) {

    }

    @Override
    public List<Drivers> listDrivers() {
        return null;
    }

    @Override
    public void removeDrivers(Integer id) {

    }

    @Override
    public Drivers findDrivers(String name) {
        return null;
    }
}
