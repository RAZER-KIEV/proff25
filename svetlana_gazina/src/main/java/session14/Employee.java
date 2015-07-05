package session14;



import javax.persistence.*;

/**
 * Created by Sveta on 6/30/2015.
 */
@Entity
public class Employee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_EMPLOYEES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "EMPLOYEE_ID")
    private long id;
    private String name;
    @ManyToOne
    private Company company;


}
