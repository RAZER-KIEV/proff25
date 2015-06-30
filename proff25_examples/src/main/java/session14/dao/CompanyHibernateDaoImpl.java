package session14.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session14.domain.Company;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.05.13
 */
@Repository
@Transactional
public class CompanyHibernateDaoImpl implements CompanyDao {
    private static Logger log = Logger.getLogger(CompanyHibernateDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    public CompanyHibernateDaoImpl() {
    }

    @Override
    public void create(Company client) {
        factory.getCurrentSession().save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Company read(Long id) {
        return (Company) factory.getCurrentSession().get(Company.class, id);
    }

    @Override
    public void update(Company client) {
        factory.getCurrentSession().save(client);
    }

    @Override
    public void delete(Company client) {
        factory.getCurrentSession().delete(client);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Company> findAll() {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Company");
        return query.list();
    }

    @Override
    public List<Company> findMonyGT(long amount) {
        return null;
    }
}
