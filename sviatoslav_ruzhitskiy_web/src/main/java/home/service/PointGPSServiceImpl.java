package home.service;

import home.domain.PointGPS;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Service
@Transactional
public class PointGPSServiceImpl implements PointGPSService{
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
