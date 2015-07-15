package scrum.dao;

import scrum.domain.Driver;

import java.util.List;

public interface DriverDao {
    Long create(Driver driver);
    Driver read(Long id);
    boolean update(Driver driver);
    boolean delete(Driver driver);
    List findAll();
}
