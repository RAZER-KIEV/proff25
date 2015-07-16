package taxi.dao;

import org.springframework.stereotype.Repository;
import taxi.domain.Role;

import java.util.List;

/**
 * Created by GFalcon on 16.07.15.
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Override
    public String create(Role role) {
        return null;
    }

    @Override
    public Role read(String roleName) {
        return null;
    }

    @Override
    public boolean update(Role role) {
        return false;
    }

    @Override
    public boolean delete(Role role) {
        return false;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }
}
