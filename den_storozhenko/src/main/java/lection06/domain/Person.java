package lection06.domain;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "PERSON_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "PERSON_ID")
    private Long id;
    @Column(name = "PERSON_NAME")
    private String name;
    @ManyToOne
    private Company company;

    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Long id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void print(){
        System.out.println(id+" "+name+" "+company.getName());
    }
}
