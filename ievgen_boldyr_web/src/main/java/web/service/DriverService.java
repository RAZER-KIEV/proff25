package web.service;

import web.domain.Drivers;

import java.util.List;


/**
 * Created by george on 20.07.15.
 */
public interface DriverService {

    void addDrivers(Drivers drivers);

    List<Drivers> listDrivers();

    void removeDrivers(Integer id);

    Drivers findDrivers(String name);
}
