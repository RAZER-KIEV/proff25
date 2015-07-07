package session11;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Inna on 22.06.2015.
 */
@Table(name = "Companies")
@Entity
public class Company {
    @Id
    private Long id;

    @Column(name = "CompanyName")
    private String name;

    @OneToMany
    private Set<Employee> employee = new HashSet<>();

    public Company(String name) {
        this.name = name;
    }

    public Company(Long id, String name, Set<Employee> employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public Company() {

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

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
