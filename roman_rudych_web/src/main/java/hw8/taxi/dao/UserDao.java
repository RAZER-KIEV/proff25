package hw8.taxi.dao;

import hw8.taxi.domain.User;

import java.util.List;

/**
 * Created by Роман on 11.07.2015.
 */
public interface UserDao {
    Long create(User user);
    User read(Long ig);
    boolean update(User user);
    boolean delete(User user);
    public User getByName(String name);
    List findAll();
    boolean isExistingSpecId(String id);
    boolean isExistingName(String name);
    boolean authenticate(String login, String pass);
}
