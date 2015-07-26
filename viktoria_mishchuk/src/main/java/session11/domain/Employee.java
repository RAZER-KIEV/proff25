package session11.domain;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;

/**
 * Created by viktoria
 * Project:.session11
 */

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @SequenceGenerator(name= "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column (name = "ID")
    private Long id;

    @Column (name = "NAME")
    private String employeeName;

    @ManyToOne
    private Company company;

    public Employee(){

    }

    public Employee(String employeeName){

        this.employeeName = employeeName;
    }

   /* public Employee(String employeeName, Company company){
        this.employeeName = employeeName;
        this.company = company;
    }*/

    private SessionFactory factory;

    public Employee(SessionFactory factory){
        this.factory = factory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }




}
