package home.dao;

import home.domain.Admin;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
public interface AdminDao {
    Long create(Admin admin);
    Admin read(Long id);
    boolean update(Admin admin);
    boolean delete(Admin admin);
    Admin searchByLogin(String login);
    Long getDBSize();
    List findAll();

}
