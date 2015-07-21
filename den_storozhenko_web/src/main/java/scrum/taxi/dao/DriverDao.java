package scrum.taxi.dao;

import scrum.taxi.domain.Driver;

import java.util.List;

/**
 * Created by storo_000 on 14.07.2015.
 */
public interface DriverDao {
    Long create(Driver driver);
    Driver read(Long id);
    //Driver readByName(String name, String surname);
    boolean update(Driver driver);
    boolean delete(Driver driver);
    List findAll();
}
