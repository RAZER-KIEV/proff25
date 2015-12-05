package home.service;

import home.domain.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Override
    public Long create(Admin admin) {
        return null;
    }

    @Override
    public Admin read(Long id) {
        return null;
    }

    @Override
    public boolean update(Admin admin) {
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        return false;
    }

    @Override
    public Admin searchByLogin(String login) {
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
