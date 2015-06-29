package session11;

/**
 * Created by Віктор on 6/22/2015.
 */
public class Company {
    private String nameOfCompany;
    private Double money;

    private Employee employee;

    public Company(String nameOfCompany, Double money) {
        this.nameOfCompany = nameOfCompany;
        this.money = money;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee() {
        this.employee = employee;
    }
}
