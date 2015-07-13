package lection07;
import lection06.domain.Person;
import lection06.service.CompanyService;
import lection06.service.CompanyServiceImpl;
import lection06.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
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
 * приложение с консольным меню в котором пользователь вводит имя компании, вывести всех сотрудников, которые в ней работают
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("lection07/transactionalContext.xml");
        CompanyService companyService = context.getBean("companyServiceImpl", CompanyService.class);
        View view = new View(companyService);
        view.menu();

    }
}
