package scrum.dao;


import java.util.List;

/**
 * Created by User on 14.07.2015.
 */
public interface TaxiDao {
    Long create(Taxi taxi);
    Taxi read(Long id);
    void update(Taxi taxi);
    void delete(Taxi taxi);
    List listAll();
}
