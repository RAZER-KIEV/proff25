package home.dao;

import home.domain.Technician;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
public interface TechnicianDao {
    Long create(Technician tech);
    Technician read(Long ig);
    boolean update(Technician tech);
    boolean delete(Technician tech);
    Technician searchByLogin(String login);
    Long getDBSize();
    List findAll();
}
