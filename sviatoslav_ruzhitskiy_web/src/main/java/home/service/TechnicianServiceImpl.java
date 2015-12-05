package home.service;

import home.dao.TechnicianDao;
import home.domain.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Service
@Transactional
public class TechnicianServiceImpl  implements TechnicianService {

    @Autowired
    TechnicianDao technicianDao;

    @Override
    public Long create(Technician tech) {
        return null;
    }

    @Override
    public Technician read(Long ig) {
        return null;
    }

    @Override
    public boolean update(Technician tech) {
        return false;
    }

    @Override
    public boolean delete(Technician tech) {
        return false;
    }

    @Override
    public Technician searchByLogin(String login) {
        return null;
    }

    @Override
    public Long getDBSize() {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
