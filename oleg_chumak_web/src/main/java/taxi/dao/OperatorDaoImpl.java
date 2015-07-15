package taxi.dao;

import taxi.domain.Operator;

import java.util.List;

/**
 * Created by GFalcon on 16.07.15.
 */
public class OperatorDaoImpl implements OperatorDao {
    @Override
    public String create(Operator operator) {
        return null;
    }

    @Override
    public Operator read(String login) {
        return null;
    }

    @Override
    public boolean update(Operator operator) {
        return false;
    }

    @Override
    public boolean delete(Operator operator) {
        return false;
    }

    @Override
    public List<Operator> findAll() {
        return null;
    }

    @Override
    public boolean auth(String login, String password) {
        return false;
    }
}
