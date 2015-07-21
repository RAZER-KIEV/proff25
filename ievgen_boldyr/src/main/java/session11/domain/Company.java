package session11.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nucleos on 13.12.14.
 */

@Entity
@Table(name = "Companies")
public class Company {

    @Id
    @SequenceGenerator(name="sequance",  sequenceName = "region_id", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequance")
    @Column(name = "id")
    private Long id;

    @Column(name = "company")
    private String company;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @Column(name = "balance")
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Company() {}
    public Company(String company, Double balance) {
        this.company = company;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
