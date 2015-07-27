package session13;

import javax.xml.soap.SAAJResult;

/**
 * Created by viktoria
 * Project:.session13
 */
public class Company {
    private String company;
    private Double balance;
    private Car car;

    public Company(){}

    public Company(String company,Double balance, Car car) {
        this.company = company;
        this.balance = balance;
        this.car = car;
    }


    @Override
    public String toString(){
        return "Company: " +company+ " .   Balance: " + balance + ". Car: " + car;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
