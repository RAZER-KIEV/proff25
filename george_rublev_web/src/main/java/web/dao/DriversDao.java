package web.dao;

import web.domain.Client;
import web.domain.Drivers;

import java.util.List;

/**
 * Created by george on 21.07.15.
 */
public interface DriversDao {
    List<Drivers> listDrivers();
}
