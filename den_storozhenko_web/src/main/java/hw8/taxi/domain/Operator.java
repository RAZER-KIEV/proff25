package hw8.taxi.domain;

import hw8.taxi.UserRole;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name="OPERATORS")

public class Operator {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "OPERATORS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "OPERATOR_ID")
    private Long id;
    @Column(name = "IDENT_NUMBER")
    private String idnumb;
    @Column(name = "LOGIN", unique = true)
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    private UserRole role;
    @Column(name = "REGISTRATION_DATE")
    private Date date;
    @Column(name = "CHANGED_PASS_DATE")
    private Date passDate;
    @Column(name = "COUNT_WRONG_PASSWORDS")
    private Integer countWrongPass;
    @Column(name = "IS_BLOCKED")
    private Boolean isBlocked;

    public Operator() {
    }

    public Operator(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        role = UserRole.USER;
        idnumb = "0000000000";
        date = new Date();
        passDate = new Date();
        countWrongPass = 0;
        isBlocked = false;
    }

    public Operator(String login, String password) {
        this.login = login;
        this.password = password;
        role = UserRole.USER;
        idnumb = "0000000000";
        date = new Date();
        passDate = new Date();
        countWrongPass = 0;
        isBlocked = false;
    }

    public Operator(String idnumb, String login, String password) {
        this.idnumb = idnumb;
        this.login = login;
        this.password = password;
        role = UserRole.USER;
        date = new Date();
        passDate = new Date();
        countWrongPass = 0;
        isBlocked = false;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Operator(Long id, String login, String password, UserRole role, String idnumb, Date date, Date passDate, Integer countWrongPass, Boolean isBlocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.idnumb = idnumb;
        this.date = date;
        this.passDate = passDate;
        this.countWrongPass = countWrongPass;
        this.isBlocked = isBlocked;

    }

    public String getIdnumb() {
        return idnumb;
    }

    public void setIdnumb(String idnumb) {
        this.idnumb = idnumb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    public Integer getCountWrongPass() {
        return countWrongPass;
    }

    public void setCountWrongPass(Integer countWrongPass) {
        this.countWrongPass = countWrongPass;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", idnumb='" + idnumb + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", date=" + date +
                ", passDate=" + passDate +
                ", countWrongPass=" + countWrongPass +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
