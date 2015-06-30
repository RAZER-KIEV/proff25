package session14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sveta on 6/30/2015.
 */
@Service("service")
@Transactional
public class CompanyServiceImpl implements CompanyService {
    @Autowired (required = true)
    private CompanyDaoImpl companyDao;

    public CompanyServiceImpl() {
    }

    public CompanyDaoImpl getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(CompanyDaoImpl companyDao) {
        this.companyDao = companyDao;
    }

    public CompanyServiceImpl(CompanyDaoImpl companyDao) {

        this.companyDao = companyDao;
    }

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    @Override
    public Long create(Company comp) {
        return companyDao.create(comp);
    }

    @Override
    public List<Employee> findEmpsByComp(Company company) {
        
        return companyDao.findEmpsByComp(company);
    }
}
