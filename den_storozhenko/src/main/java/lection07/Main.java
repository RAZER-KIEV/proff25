package lection07;
import lection06.domain.Company;
import lection06.dao.CompanyDAOImpl;
import lection06.service.CompanyServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Создать класс Компания
 * имя, деньги на счету
 * класс Директор
 * имя, работает в компании
 * класс Машина
 * пренадлежит компании, ездит директор
 *
 *
 *
 * Получить все компании, вывести на экран
 * spring
 * dao
 * beans: источник данных, фабрика сессий, дао, property-placeholder
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("lection07/context-db-new.xml");
        CompanyServiceImpl companyService = context.getBean("companyServiceImpl", CompanyServiceImpl.class);
        for (Company company:companyService.findAll()){
            company.print();
        }

    }
}
