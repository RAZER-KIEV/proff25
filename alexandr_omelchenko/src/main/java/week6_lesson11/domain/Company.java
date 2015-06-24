package week6_lesson11.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by HP on 22.06.2015.
 */
@Entity
@Table (name = "COMPANY")
public class Company {

    @OneToMany(
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "company",  // включить двунаправленность
            cascade = CascadeType.ALL // каскадирование
    )
    private Set<Employee> employees = new HashSet<>();
    public Company() {
        name = "Defoult";
        budget = 100000.00;
    }
    public Company(String name, Double budget) {
        this.name = name;
        this.budget=budget;
    }
    public Company(String name, Double money, Set<Employee> employees) {
        this.name = name;
        this.budget = money;
        this.employees = employees;
    }
    @Id
    @SequenceGenerator(name="sequence", sequenceName="ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
    private Long id;
    @Column(name ="NAME")
    private String name;
    @Column(name ="Budget")
    private Double budget;

    public boolean addEmployee(Employee employee){
        return employees.add(employee);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getBudget() {
        return budget;
    }
    public void setBudget(Double money) {
        this.budget = money;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Set<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                '}';
    }
}