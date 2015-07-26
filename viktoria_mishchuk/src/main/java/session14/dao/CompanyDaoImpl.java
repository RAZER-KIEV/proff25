package session14.dao;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import session14.domain.Company;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session14.
 */

@Component
public class CompanyDaoImpl implements CompanyDao{

    @Autowired (required = true)
    private SessionFactory factory;
    private Logger log = Logger.getLogger(CompanyDaoImpl.class);

//    public CompanyDaoImpl(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-db.xml");
//
//            }

//    public CompanyDaoImpl(SessionFactory factory){
//        this.factory = factory;
//    }


    @Override
    public List findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Company");
        return query.list();

    }

}

