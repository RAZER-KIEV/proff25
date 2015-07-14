package scrum.dao;

import hw8.taxi.domain.Client;
import scrum.domain.User;

import java.util.List;

/**
 * Created by GFalcon on 14.07.15.
 */
public interface UserDao {
    Long create(User user);
    Client read(Long id);
    void update(User user);
    void delete(User user);
    List listAll();
}
