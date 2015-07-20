package taxi.dao;

import taxi.domain.TaxiDriver;

import java.util.List;

/**
 * Created by HP on 16.07.2015.
 */
public interface TaxiDriverDao {
    public TaxiDriver read(Long id);

    public Long create(TaxiDriver taxiDriver);

    public boolean update(TaxiDriver taxiDriver);

    public boolean delete(TaxiDriver taxiDriver);

    public List findAll();
}
