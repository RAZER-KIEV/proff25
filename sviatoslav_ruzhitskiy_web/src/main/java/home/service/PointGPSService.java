package home.service;

import home.domain.PointGPS;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
public interface PointGPSService {
    Long create(PointGPS pointGPS);
    PointGPS read(Long id);
    boolean update(PointGPS pointGPS);
    boolean delete(PointGPS pointGPS);
    List findAll();

}
