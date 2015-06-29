package session11_12;

import javax.persistence.*;

/**
 * Created by Sveta on 6/22/2015.
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_EMPLOYEES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "EMPLOYEE_ID")
    private long id;
    @Column(name = "EMPLOYEE_NAME")
    private String name;
    @ManyToOne
    private Company company;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
