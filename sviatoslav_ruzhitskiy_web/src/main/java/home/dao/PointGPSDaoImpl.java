package home.dao;

import home.domain.PointGPS;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Repository
public class PointGPSDaoImpl implements PointGPSDao{
    @Override
    public Long create(PointGPS pointGPS) {
        return null;
    }

    @Override
    public PointGPS read(Long id) {
        return null;
    }

    @Override
    public boolean update(PointGPS pointGPS) {
        return false;
    }

    @Override
    public boolean delete(PointGPS pointGPS) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }
}
