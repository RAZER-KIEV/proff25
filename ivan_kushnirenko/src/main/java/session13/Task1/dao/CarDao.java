package session13.Task1.dao;

import session13.Task1.domain.Car;

import java.util.List;

/**
 * Created by ivan on 30.06.15.
 */
public interface CarDao {

    Long create(Car car);

    Car read(Long id);

    boolean update(Car car);

    boolean delete(Car car);

    List findAll();
}
