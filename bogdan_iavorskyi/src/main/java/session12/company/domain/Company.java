package session12.company.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
 * Created on 22.06.15.
 */
@Entity
@Table(name="COMPANIES")
public class Company {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Person> persons = new HashSet<>();

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANY_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String name;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public void hire(Person person) {
        if (person.getCompany() == null) {
            persons.add(person);
            person.setCompany(this);
        }
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
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
        return "Company{" +
                ", name='" + name + '\'' +
                '}';
    }
}
