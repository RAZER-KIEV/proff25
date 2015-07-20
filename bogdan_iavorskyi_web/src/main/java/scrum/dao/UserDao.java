package scrum.dao;

import scrum.domain.User;

import java.util.List;

/**
 * Created by GFalcon on 14.07.15.
 */
public interface UserDao {
    Long create(User user);
    User read(Long id);
    void update(User user);
    void delete(User user);
    List listAll();
}
