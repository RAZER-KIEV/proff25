package session11_12;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Sveta on 6/23/2015.
 */
public class CompanyServiceImpl implements CompanyService {
    private SessionFactory factory;
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public CompanyServiceImpl(Session session, SessionFactory factory) {
        this.session = session;
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Object[]> getEmpFromAllCompanies() {
        Query query = session.createQuery("from session11_12.Company c full join c.employees");

        return query.list();
    }

    @Override
    public List<Object[]> getEmpFromCompany(String company) {
        Query query = session.createQuery("from session11_12.Company c inner join c.employees");

        return query.list();

    }
}
