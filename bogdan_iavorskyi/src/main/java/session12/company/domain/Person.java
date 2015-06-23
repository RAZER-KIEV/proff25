package session12.company.domain;

import javax.persistence.*;

/*
 * Created on 22.06.15.
 */

@Entity
@Table(name="PERSONS")
public class Person {

    @ManyToOne
    private Company company;

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PERSON_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "PERSON_ID")
    private Long id;

    @Column(name = "PERSON_NAME")
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "company=" + company +
                ", name='" + name + '\'' +
                '}';
    }
}
