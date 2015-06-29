package session11.domain;

import javax.persistence.*;

/**
 * Created by ivan on 22.06.15.
 */
@Entity
@Table
public class Employee {

    private Long id;
    private Company company;
    private String name;


    public Employee(){
        this("Employee",null);
    }

    public Employee(String name, Company company){
        this.name=name;
        this.company=company;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return new String("Name is "+name+", company name: "+company.getName()+".");
    }
}
