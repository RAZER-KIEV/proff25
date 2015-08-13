package hw8.taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sveta on 7/18/2015.
 */
@Entity
@Component
public class Operator {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "OPERATORS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "OPERATOR_ID")
    private Long id;
    private String login;
    private String inn;
    private String password;
    private Date passDate;
    private Boolean isBlocked;
    private Integer wrongPass;

    public Operator(){}
    public Operator(String login, String password, String inn){
        this.login = login;
        this.password=password;
        this.inn=inn;
        passDate = new Date();
        isBlocked=false;
        wrongPass=0;

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

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Integer getWrongPass() {
        return wrongPass;
    }

    public void setWrongPass(Integer wrongPass) {
        this.wrongPass = wrongPass;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", inn='" + inn + '\'' +
                ", password='" + password + '\'' +
                ", passDate=" + passDate +
                ", isBlocked=" + isBlocked +
                ", wrongPass=" + wrongPass +
                '}';
    }
}
