package week6_lesson11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import week6_lesson11.dao.CompanyDaoImpl;
import week6_lesson11.dao.EmployeeDaoImpl;
import week6_lesson11.domain.Company;
import week6_lesson11.util.HiberUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by HP on 22.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        HiberUtil hiberUtil =new HiberUtil();
        List list1;
        List list2;
        CompanyDaoImpl compDao = new CompanyDaoImpl(hiberUtil.initialize());
        EmployeeDaoImpl emplDao = new EmployeeDaoImpl(hiberUtil.initialize());
     //   Company company =compDao.read(45L);
      //  list1 = compDao.getEmplFromAllComp();
      //  list2 = emplDao.getEmplFromCompany(company);

        list1 =compDao.getCompWhereMoreThanEmpl(2L);
        System.out.println(list1);
      //  System.out.println(list2);


        compDao.factoryClose();
        emplDao.factoryClose();
    }
}