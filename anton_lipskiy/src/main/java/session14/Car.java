package session14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Липский on 29.06.2015.
 */
@Component("car")
public class Car {

    @Autowired(required = true)
    private Company company;
    @Value("Lexud")
    private String name;


    public Car(String s) {
    }

    public Car() {
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", company=" + company.toString() +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
