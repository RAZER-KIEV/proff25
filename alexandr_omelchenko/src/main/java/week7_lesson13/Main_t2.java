package week7_lesson13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week6_lesson11.dao.CompanyDaoImpl;
import week6_lesson11.domain.Company;
import week6_lesson11.util.HiberUtil;

/**
 * Created by HP on 29.06.2015.
 */
public class Main_t2 {
    public static void main(String[] args) {
      /*  HiberUtil hiberU = new HiberUtil();
CompanyDaoImpl dao = new CompanyDaoImpl(hiberU.initialize());
        Company c=dao.read(45L);
        System.out.println(c.getName());
      */
    ApplicationContext context = new ClassPathXmlApplicationContext("session13/context-db.xml");
    CompanyDaoImpl companyDao = context.getBean("dao", CompanyDaoImpl.class);
        Company comp = companyDao.read(45L);
        System.out.println(comp.getName());
        companyDao.factoryClose();
}

}