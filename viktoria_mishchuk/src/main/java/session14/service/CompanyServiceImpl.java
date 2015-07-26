package session14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import session14.dao.CompanyDao;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session14.service
 */

@Component
@Transactional
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyDao dao;

    @Override
    @Transactional (readOnly = true)
    public List findAll() {
        return dao.findAll();
    }
}
