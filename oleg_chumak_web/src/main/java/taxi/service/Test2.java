package taxi.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import taxi.dao.RoleDao;
import taxi.domain.Role;

import java.util.Locale;

/**
 * Created by HP on 16.07.2015.
 */
public class Test2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("taxi/context.xml");

        TService service1 = context.getBean("tServiceImpl", TService.class);
   //     ClientDao service2 = context.getBean("clientDaoImpl", ClientDao.class);
   //     OperatorDao service3 = context.getBean("operatorDaoImpl", OperatorDao.class);
   //     RoleDao service4 = context.getBean("roleDaoImpl", RoleDao.class);
   //     OrderDao service5 = context.getBean("orderDaoImpl", OrderDao.class);
        //    service.createOperator()
     //   service.createTaxist(new TaxiDriver("Balvan", "Mercedes", "AA0001AA", "0939393933"));

    }
}
