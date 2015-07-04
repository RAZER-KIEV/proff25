package lection06.view;

import lection06.domain.Person;
import lection06.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Scanner;

/**
 * Created by storo_000 on 30.06.2015.
 */
public class View {
    @Autowired
    private CompanyService companyService;

    public View(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostConstruct
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - to print emploies from company\ne - exit");
            String choice = scanner.nextLine();
            if (choice.equals("e")) {
                return;
            }
            if (choice.equals("1")) {
                System.out.println("Enter name of company:");
                choice = scanner.nextLine();
                for (Person person : (List<Person>) companyService.getEmploiesFromCompany(choice)) {
                    person.print();
                }
            }
        }
    }


}
