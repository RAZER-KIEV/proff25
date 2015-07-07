package session11;

import javax.persistence.*;

import java.util.Set;

/**
 * Created by Inna on 22.06.2015.
 */
@Entity
@Table (name = "Employees")
public class Employee {
    @Id
    private Long id;

    @Column (name = "EmployeeName")
    private String name;

    @ManyToOne
    private Company company;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Long id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
