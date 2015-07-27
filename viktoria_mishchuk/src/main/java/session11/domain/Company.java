package session11.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by viktoria
 * Project:.session11
 */

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @SequenceGenerator(name= "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column (name = "ID")
    private Long id;

    @Column (name = "NAME")
    private String companyName;

    @Column (name = "BALANCE")
    private Double balance;

    @OneToMany
    private Set <Employee> employees;

    public Company(){

    }

    public Company(String companyName, Double balance){
        this.companyName = companyName;
        this.balance = balance;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    public boolean getJob(Employee emp){
        emp.setCompany(this);
        return true;

    }
}
