package session12;

import session11.Employee;

import java.util.List;

/**
 * Created by Віктор on 6/23/2015.
 */
public class Company {
    private String nameOfCompany;

    private Employee employee;

    public Company(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public Company (Employee employee){
        this.employee = employee;
    }
}
