package home.service;

import home.dao.OfficeDao;
import home.domain.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RAZER on 11-Mar-16.
 */
@Service
@Transactional
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    EventService eventService;

    @Autowired
    OfficeDao officeDao;

    @Override
    public Long create(Office office) {
        return officeDao.create(office);
    }

    @Override
    public Office read(Long id) {
        return officeDao.read(id);
    }

    @Override
    public boolean update(Office office) {
        return officeDao.update(office);
    }

    @Override
    public boolean delete(Office office) {
        return officeDao.delete(office);
    }

    @Override
    public List findAll(Long networkId) {
        return officeDao.findAll(networkId);
    }
}
