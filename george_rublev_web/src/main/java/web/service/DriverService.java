package web.service;

import web.domain.Drivers;
import web.domain.Operator;

//import java.sql.Driver;
import java.util.List;

/**
 * Created by george on 20.07.15.
 */
public interface DriverService {
    public void addDrivers(Drivers drivers);
    public List<Drivers> listDrivers();
    public void removeDrivers(Integer id);
    public Drivers findDrivers(String name);
}
