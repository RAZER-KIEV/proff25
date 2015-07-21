package session12.company.view;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import session12.company.domain.Company;
import session12.company.domain.Person;
import session12.company.service.PersonService;
import session12.company.util.HibernateUtil;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
 * Created on 22.06.15.
 */
@Component
public class Menu {

    @Autowired
    private PersonService personService;

    @PostConstruct
    public void menu() {

    }

}
