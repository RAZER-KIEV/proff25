package session11.domain;

import javax.persistence.*;


/**
 * Created by nucleos on 13.12.14.
 */

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @SequenceGenerator(name="sequance",  sequenceName = "region_id", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequance")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "expirience")
    private String expirience;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    public Employee() {}
    public Employee(String name, String expirience, Double salary, Company company) {
        this.name = name;
        this.expirience = expirience;
        this.salary = salary;
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

    public String getExpirience() {
        return expirience;
    }

    public void setExpirience(String expirience) {
        this.expirience = expirience;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getCompany();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
