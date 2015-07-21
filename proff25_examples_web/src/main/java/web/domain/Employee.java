package web.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Entity
@Table(name = "EMPLOYEES")
@SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEES_SEQ")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Integer id;

    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;

    @Column(name = "LAST_NAME", length = 25)
    private String lastName;

    @Column(name = "EMAIL", length = 25)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 25)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "HIRE_DATE")
    private Date hireDate;

    //    @ManyToOne
//    @JoinColumn(name = "JOB_ID")
    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "SALARY")
    private Integer salary;

    @Column(name = "COMMISSION_PCT")
    private Integer comissionPct;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @Column(name = "DEPARTMENT_ID")
//        @OneToOne
//        @JoinColumn(name = "DEPARTMENT_ID")
    private Long departmentId;

    public Employee() {

    }

    public Employee(String firstName) {
        this.firstName = firstName;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getComissionPct() {
        return comissionPct;
    }

    public void setComissionPct(Integer comissionPct) {
        this.comissionPct = comissionPct;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
                + ", salary=" + salary + ", comissionPct="
                + comissionPct + ", manager=\n" + manager + ",\n " +
                "]";
    }
}
