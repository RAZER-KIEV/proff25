package taxi.dao;

import taxi.domain.Role;

import java.util.List;

/**
 * Created by GFalcon on 16.07.15.
 */
public interface RoleDao {
    String create(Role role);
    Role read(String roleName);
    boolean update(Role role);
    boolean delete(Role role);
    List<Role> findAll();
}
