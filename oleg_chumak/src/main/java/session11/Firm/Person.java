package session11.Firm;

import javax.persistence.*;

/**
 * Created by oleg on 22.06.15.
 */


@Entity
@Table(name="PERSON")
public class Person {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PERSON_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    private Company company;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
