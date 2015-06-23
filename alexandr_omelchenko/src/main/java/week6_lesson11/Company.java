package week6_lesson11;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HP on 22.06.2015.
 */
@Entity
@Table
public class Company {
    @OneToMany
    private Set<Emploee> emploees = new HashSet<>();
    public Company() {
        name = "Defoult";
        budget = 100000.;
    }
    public Company(String name, Double budget) {
        this.name = name;
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

    public boolean addEmploee(Emploee emploee){
        return emploees.add(emploee);
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
    public Set<Emploee> getEmploees() {
        return emploees;
    }
    public void setEmploees(Set<Emploee> emploees) {
        this.emploees = emploees;
    }
}
