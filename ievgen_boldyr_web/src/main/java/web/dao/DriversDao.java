package web.dao;

import web.domain.Drivers;
import web.domain.Operator;

import java.util.List;

/**
 * Created by george on 21.07.15.
 */
public interface DriversDao {

    Long createDriver(Drivers drivers);

    Drivers readDriver(Long id);

    boolean updateDriver(Drivers drivers);

    boolean deleteDriver(Drivers drivers);

    List<Drivers> listDrivers();
}
