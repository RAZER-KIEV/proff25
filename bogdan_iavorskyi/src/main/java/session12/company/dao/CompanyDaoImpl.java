package session12.company.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import session12.company.domain.Company;

/**
 * Created by bosyi on 23.06.15.
 */
public class CompanyDaoImpl implements CompanyDao {


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
        return (Company) factory.getCurrentSession().get(Company.class, id);
    }

    @Override
    public void update(Company company) {
    }

    @Override
    public void delete(Company company) {
    }
}
