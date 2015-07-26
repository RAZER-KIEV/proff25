package session14.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session14.domain.Company;

import java.util.Scanner;

/**
 * Created by viktoria
 * Project:.session14.service
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter Company's name");
        String val = scanner.nextLine();

        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-db.xml");

        CompanyService service = context.getBean(CompanyServiceImpl.class);
        System.out.println(service.findAll());

    }
}
