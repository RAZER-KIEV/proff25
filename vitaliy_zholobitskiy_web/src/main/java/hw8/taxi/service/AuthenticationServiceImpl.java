package hw8.taxi.service;

import hw8.taxi.controller.AuthenticationController;
import hw8.taxi.exception.AuthenticationException;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by just1ce on 11.07.2015.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired(required=true)
    private SessionFactory  sessionFactory;
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        Query query = sessionFactory.openSession().createQuery("from Account a where a.login=:login and a.pass=:pass");
        query.setParameter("login",login);
        query.setParameter("pass",pass);
        if (!query.list().isEmpty())
            return true;
        return false;

    }
}
