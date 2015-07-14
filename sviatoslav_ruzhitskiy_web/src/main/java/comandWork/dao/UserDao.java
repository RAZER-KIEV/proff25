package comandWork.dao;

import comandWork.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by RAZER on 14.07.2015.
 */
public interface UserDao {
    Long create(User user);
    User read(Long id);
    User readByName(String login);
    boolean update(User user);
    boolean delete(User user);
    List findAll();
}
