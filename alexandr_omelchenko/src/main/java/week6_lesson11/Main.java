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
        List list;
        CompanyDaoImpl compDao = new CompanyDaoImpl(hiberUtil.initialize());
        list = compDao.getEmplFromAllComp();
        System.out.println(list);
        Company company =compDao.read(34L);
        compDao.factoryClose();
      //  list = comp.getEmplFromAllComp();
     //   System.out.println(list.toString());
     //   comp.factoryClose();
        EmployeeDaoImpl empl = new EmployeeDaoImpl(hiberUtil.initialize());

        list = empl.getEmplFromCompany(company);
        System.out.println(list);
        empl.factoryClose();
    }
}