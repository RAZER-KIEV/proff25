package session14.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by viktoria
 * Project:.session14
 */

@Entity
@Component
public class Company {
    @Id
    private Long id;

    @Value("apple")
    private String companyName;

    private Double balance;


    public Company() {
    }

    public Company(String company, Double balance) {
        this.companyName = company;
        this.balance = balance;

    }


    @Override
    public String toString() {
        return "Company: " + companyName + " .   Balance: " + balance;
    }

    public String getCompany() {
        return companyName;
    }

    public void setCompany(String company) {
        this.companyName = company;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
