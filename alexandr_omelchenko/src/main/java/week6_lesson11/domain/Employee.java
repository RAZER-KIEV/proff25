package week6_lesson11.domain;

import javax.persistence.*;
/**
 * Created by HP on 22.06.2015.
 */
@Entity
@Table(name="Employee")
public class Employee {
    @ManyToOne

    private Company company;

    public Employee() {
        name = "Ivanov" ;
    }
    public Employee(String name) {
        this.name = name;
    }
    @Id
    @SequenceGenerator(name="sequence", sequenceName="ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
    private Long id;
    @Column(name ="NAME")
    private String name;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
