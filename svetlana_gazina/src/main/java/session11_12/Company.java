package session11_12;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sveta on 6/22/2015.
 */
@Entity
@Table(name = "COMPANIES")
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANIES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "COMPANY_ID")
    private long id;
    @Column(name = "COMPANY_NAME")
    private String name;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "company", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Employee> employees;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
