package hw8.taxi.service;

import hw8.taxi.domain.Driver;

public interface DriverService {
    boolean authenticate(String phone, String password);
    Long create(Driver driver);
    Driver getDriverById(Long id);
    Driver getDriverByPhone(String phone);
}
