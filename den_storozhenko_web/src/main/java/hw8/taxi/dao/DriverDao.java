package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Driver;

import java.util.List;

/**
 * Created by storo_000 on 29.07.2015.
 */
public interface DriverDao {
    Long create(Driver driver);
    Driver read(Long id);
    Driver readByPhone(String phone);
    boolean authenticate(String phone, String password);
    boolean update(Driver driver);
    boolean delete(Driver driver);
    List findAll();
}
