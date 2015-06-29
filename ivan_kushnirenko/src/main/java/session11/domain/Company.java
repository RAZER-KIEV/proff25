package session11.domain;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by ivan on 22.06.15.
 */
@Entity
@Table
public class Company {
    private Long id;
    private String name;
    private Set<Employee> employees;
    private Double count;

    public Company(){
        this("company",0D);
    }

    public Company(String name, Double count){
        this.name=name;
        this.count=count;
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

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString(){
        return new String("Company name is "+name+", count = "+count+".");
    }
}
