package scrum.taxi.dao;

import scrum.taxi.domain.User;

import java.util.List;

/**
 * Created by storo_000 on 14.07.2015.
 */
public interface UserDao {
    Long create(User user);
    User read(Long id);
    boolean auth(String login, String password);
    boolean update(User user);
    boolean delete(User user);
    List findAll();
}
