package session12.view;

//import session12.domain.Company;
import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import session12.dao.DaoCompanyImpl;
import session11.Company;
import session11.Emploee;
import session12.util.HibernateUtil;

import java.util.Set;

/**
 * Created by RAZER on 23.06.2015.
 */
public class Main {

    public static void main(String[] args) {




        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        SessionFactory sessionFactory = hibernateUtil.connectToHib();
        System.out.println(sessionFactory);

        DaoCompanyImpl daoCompany = new DaoCompanyImpl(sessionFactory);



        Company company1 = new Company("UltraComp", Double.parseDouble("2324414214"));
        Company company2 = new Company("MegaComp", Double.parseDouble("1231245125"));

/*
        Emploee emp1 = new Emploee("Uasia", company1);
        Emploee emp2 = new Emploee("Petia", company1);
        Emploee emp3 = new Emploee("Ualera", company2);
        Emploee emp4 = new Emploee("Aliosha", company2);
        Emploee emp5 = new Emploee("Siroga", company2);

        company1.addEmploee(emp1);
        company1.addEmploee(emp2);

        company2.addEmploee(emp3);
        company2.addEmploee(emp4);
        company2.addEmploee(emp5);

        daoCompany.create(company1);
        daoCompany.create(company2);
        daoCompany.create(emp1);
        daoCompany.create(emp2);
        daoCompany.create(emp3);
        daoCompany.create(emp4);
        daoCompany.create(emp5);*/

        Set<Object[]> resSet = daoCompany.getEmploeesFromCompany(company1);
        for(Object empl:resSet){
            System.out.println(empl);
        }


    }
}
