package session14;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sveta on 6/30/2015.
 */
@Entity
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANIES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "COMPANY_ID")
    private Long id;
    private String name;
    private Integer money;
    @OneToMany
    private List<Employee> employees;

    public Company() {
    }

    public Company(String name, int money) {

        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
