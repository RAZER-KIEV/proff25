package home.dao;

import home.domain.PointGPS;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
public interface PointGPSDao {
    Long create(PointGPS pointGPS);
    PointGPS read(Long id);
    boolean update(PointGPS pointGPS);
    boolean delete(PointGPS pointGPS);
    List findAll();

}
