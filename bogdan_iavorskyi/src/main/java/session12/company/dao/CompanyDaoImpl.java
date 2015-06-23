package session12.company.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session12.company.domain.Company;

/**
 * Created by bosyi on 23.06.15.
 */
public class CompanyDaoImpl implements CompanyDao {

    private static Logger log = Logger.getLogger(CompanyDaoImpl.class);

    private SessionFactory factory;

    public CompanyDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(Company company) {
        return null;
    }

    @Override
    public Company read(Long id) {
        Session session = null;
        Company company = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            company = (Company) session.get(Company.class, id);
            session.getTransaction().commit();
        } catch (HibernateException exception) {
            log.error("Session Error on read(Long id)", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return company;
    }

    @Override
    public boolean update(Company company) {
        return false;
    }

    @Override
    public boolean delete(Company company) {
        return false;
    }
}
