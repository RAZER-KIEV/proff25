package session14.domain;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import javax.persistence.*;

/**
 * Created by viktoria
 * Project:.session14
 */

@Entity
@Component
public class Employee {

    @Id
    @SequenceGenerator(name= "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column (name = "ID")
    private Long id;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", company=" + company +
                ", factory=" + factory +
                '}';
    }

    @Column (name = "NAME")
    private String employeeName;

    @ManyToOne
    private session14.domain.Company company;

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


    public session14.domain.Company getCompany() {
        return company;
    }

    public void setCompany(session14.domain.Company company) {
        this.company = company;
    }
}
