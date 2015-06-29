package lection06.view;

import lection06.HibernateUtil;
import lection06.domain.Company;
import lection06.domain.Person;
import lection06.service.CompanyServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();
        CompanyServiceImpl companyService = new CompanyServiceImpl(hibernateUtil.getFactory());
        Scanner scanner = new Scanner(System.in);

        /*System.out.println("Enter name of company:");
        for (Person person:companyService.getEmploiesFromCompany(scanner.nextLine())){
            person.print();
        }
        System.out.println();
        System.out.println();
        for (Person person:companyService.getEmploiesFromAllCompanies()) {
            person.print();
        }*/

        System.out.println("Enter count of emploies");
        for (String string:companyService.getCompaniesMoreThanPersons(Long.parseLong(scanner.nextLine()))){
            System.out.println(string);
        }
        hibernateUtil.closeFactory();
    }
}
