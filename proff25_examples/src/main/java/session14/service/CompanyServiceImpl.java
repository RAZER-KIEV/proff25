package session14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session14.dao.CompanyDao;
import session14.domain.Company;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.03.15
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao clientDao;

    @Transactional(readOnly = true)
    @Override
    public Company getByName(String name) {
        return clientDao.findAll().get(0);
    }
}
