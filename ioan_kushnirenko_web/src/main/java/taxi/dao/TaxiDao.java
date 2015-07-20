package taxi.dao;

import taxi.domain.Taxi;

import java.util.List;

/**
 * Created by Well on 14.07.2015.
 */
public interface TaxiDao {

    Long create(Taxi tax);
    Taxi read(Long id);
    boolean update(Taxi tax);
    boolean delete(Taxi tat);
    List<Taxi> findAll();

}
