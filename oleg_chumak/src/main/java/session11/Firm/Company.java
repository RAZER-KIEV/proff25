package session11.Firm;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by oleg on 22.06.15.
 */


    @Entity
    @Table(name="COMPANY")
    public class Company {

    public Company(String name, Long money, Set<Person> person) {
        this.name = name;
        this.money = money;
        this.person = person;
    }

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANY_ID", allocationSize = 1, initialValue = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

        @Id
        @Column(name="ID")
        private Long id;

        @Column(name = "NAME")
        private String name;

        @Column(name = "MONEY")
        private Long money;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Person> person = new HashSet<>();

    public Company(String name, Long money) {
        this.name = name;
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getName() {

        return name;
    }

    public Long getMoney() {
        return money;
    }

    public Company() {    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    public void addPerson(Person person){
        this.person.add(person);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
