package hw8.taxi.domain;

import javax.persistence.*;

/**
 * Created by Vlad on 04.04.2015.
 */

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEE_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "ID")
    private int emploeeID;

    @Column(name = "EMPLOYEE_LOGIN")
    private String employeeLogin;

    @Column(name = "EMPLOYEE_PASSWORD")
    private String employeePassword;

    @Column(name = "IDENTIFICATION_NUMBER")
    private String identificationNumber;

    @Column(name = "EMPLOYEE_BLOCK")
    private boolean employeeBlock;

    public Employee() {
    }

    public Employee(String employeeLogin, String employeePassword, String identificationNumber) {
        this.employeeLogin = employeeLogin;
        this.employeePassword = employeePassword;
        this.identificationNumber = identificationNumber;
        this.employeeBlock = false;
    }

    public int getEmploeeID() {
        return emploeeID;
    }

    public void setEmploeeID(int emploeeID) {
        this.emploeeID = emploeeID;
    }

    public String getEmployeeLogin() {
        return employeeLogin;
    }

    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public String getEmployeePAssword() {
        return employeePassword;
    }

    public boolean isEmployeeBlock() {
        return employeeBlock;
    }

    public void setEmployeeBlock(boolean employeeBlock) {
        this.employeeBlock = employeeBlock;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public void setEmployeePAssword(String employeePassword) {
        this.employeePassword = employeePassword;

    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
