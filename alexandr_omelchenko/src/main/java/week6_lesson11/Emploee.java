package week6_lesson11;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;

/**
 * Created by HP on 22.06.2015.
 */
@Entity
@Table(name="Emploee")
public class Emploee {
    @ManyToOne
    private Company company;

    public Emploee() {
        name = "Ivanov" ;
    }
    public Emploee(String name) {
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

}
