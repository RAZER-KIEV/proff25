package session11;

import javax.persistence.*;

/**
 * Created by Jeckgehor on 22.06.2015.
 */
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column (name = "NAME")
    private String nameEmployee;
    @ManyToOne
    private Company company;

    public Employee (String nameEmployee, Company company) {
        this.nameEmployee = nameEmployee;
        this.company = company;
    }

    public Employee (String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public void setCompany (Company company) {
        this.company = company;
    }
}
