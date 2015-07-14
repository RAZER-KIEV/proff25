package taxi.dao;


import java.util.List;

/**
 * Created by viktoria
 * Project:.hw8.taxi.dao
 */
public interface UserDao {

    Long create(User user);
    User read(Long ig);
    boolean update(User user);
    boolean delete(User user);
    List findAll();

}
