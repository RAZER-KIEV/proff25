package home.dao;

import home.domain.Network;

import java.util.List;

/**
 * Created by RAZER on 2/8/2016.
 */
public interface NetworkDao {
    Long create(Network network);
    Network read(Long id);
    boolean update(Network network);
    boolean delete(Network network);
    List findAll();
}
