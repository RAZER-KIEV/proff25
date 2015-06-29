package session11;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by Jeckgehor on 22.06.2015.
 */
@Entity
@Table(name = "Company")
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COMPANY_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column (name = "NAME")
    private String nameCompany;
    @Column (name = "ACCOUNT")
    private Double account;
    @OneToMany(mappedBy = "company")
    private Set<Employee> setEmployee;

    public Company (String nameCompany, Double account) {
        this.nameCompany = nameCompany;
        this.account = account;
    }

    public void setEmployee (Set<Employee> setEmployee) {
        this.setEmployee = setEmployee;
    }
}
