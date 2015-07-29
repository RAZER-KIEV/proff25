package hw8.taxi;

import hw8.taxi.dao.DriverDao;
import hw8.taxi.dao.DriverDaoImpl;
import hw8.taxi.domain.Driver;
import hw8.taxi.service.DriverService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("hw8/context.xml");
        DriverService driverService = applicationContext.getBean("driverServiceImpl", DriverService.class);
        driverService.create(new Driver("Driver1","380991111111","1111"));
        //System.out.println(IsValid.isValidPhone("+389999999999"));
    }
}
