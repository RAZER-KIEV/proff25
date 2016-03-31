package home.service;

import home.dao.PointGPSDao;
import home.domain.PointGPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Service
@Transactional
public class PointGPSServiceImpl implements PointGPSService{
    @Autowired
    PointGPSDao pointGPSDao;

    @Override
    public Long create(PointGPS pointGPS) {
        return pointGPSDao.create(pointGPS);
    }

    @Override
    public PointGPS read(Long id) {
        return pointGPSDao.read(id);
    }

    @Override
    public boolean update(PointGPS pointGPS) {
        return pointGPSDao.update(pointGPS);
    }

    @Override
    public boolean delete(PointGPS pointGPS) {
        return pointGPSDao.delete(pointGPS);
    }

    @Override
    public List findAll() {
        return pointGPSDao.findAll();
    }
}
