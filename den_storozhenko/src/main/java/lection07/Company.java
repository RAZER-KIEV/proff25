package lection07;

import lection06.domain.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPANY")
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COMPANY_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "COMPANY_ID")
    private Long id;
    @Column(name = "COMPANY_NAME")
    private String name;
    @Column(name = "CASH")
    private Integer cash;
    @OneToMany
    private Set<lection06.domain.Person> persons = new HashSet<>();

    public Company(){
    }

    public Company(String name, int cash) {
        this.name = name;
        this.cash = cash;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setPersons(Set<lection06.domain.Person> persons) {
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void print(){
        System.out.println(id+" "+name+" "+cash);
    }
}
