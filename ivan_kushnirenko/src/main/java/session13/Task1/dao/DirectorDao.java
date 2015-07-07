package session13.Task1.dao;

import session13.Task1.domain.Director;

import java.util.List;

/**
 * Created by ivan on 30.06.15.
 */
public interface DirectorDao {

    Long create(Director director);

    Director read(Long id);

    boolean update(Director director);

    boolean delete(Director director);

    List findAll();
}
