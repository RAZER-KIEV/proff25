package home.domain;

import home.enums.EmplPossition;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by ПК on 11.12.2015.
 */


@Entity
@Component
public class Employee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Employee_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "Employee_ID")
    private Long id;
    private Long networkId;
    @Enumerated(EnumType.STRING)
    private EmplPossition position;            // "admin", "tech", "superAdmin"
    private String login;
    private String password;
    private String inn;
    private String phone;
    private String home;
    private Date regdate;
    private Integer wrongPass;
    private Integer bonusSumm;
    private Boolean isBlocked;
    private Boolean isBusy;
    private Double lastLat;
    private Double lastLong;
    private Date lastOnline;
    private Long currentTaskId;

    public Employee() {
    }

    public Employee(String login, String password) {
        this.login = login;
        this.password = password;
        isBlocked = false;
        isBusy = false;
        regdate = new Date();
        lastOnline = new Date();
        position = EmplPossition.TECHNICIAN;
        inn="";
        phone="";
        home="";
        wrongPass = 0;
        bonusSumm = 0;
        lastLat = 0.0;
        lastLong =0.0;
    }

    public Employee(Long networkId, EmplPossition position, String login, String password, String inn, String phone, String home, Date regdate, Integer wrongPass, Integer bonusSumm, Boolean isBlocked, Boolean isBusy, Double lastLat, Double lastLong, Date lastOnline, Long currentTaskId) {
        this.networkId = networkId;
        this.position = position;
        this.login = login;
        this.password = password;
        this.inn = inn;
        this.phone = phone;
        this.home = home;
        this.regdate = regdate;
        this.wrongPass = wrongPass;
        this.bonusSumm = bonusSumm;
        this.isBlocked = isBlocked;
        this.isBusy = isBusy;
        this.lastLat = lastLat;
        this.lastLong = lastLong;
        this.lastOnline = lastOnline;
        this.currentTaskId = currentTaskId;
    }

    public Long getCurrentTaskId() {
        return currentTaskId;
    }

    public void setCurrentTaskId(Long currentTaskId) {
        this.currentTaskId = currentTaskId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmplPossition getPosition() {
        return position;
    }

    public void setPosition(EmplPossition position) {
        this.position = position;
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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getWrongPass() {
        return wrongPass;
    }

    public void setWrongPass(Integer wrongPass) {
        this.wrongPass = wrongPass;
    }

    public Integer getBonusSumm() {
        return bonusSumm;
    }

    public void setBonusSumm(Integer bonusSumm) {
        this.bonusSumm = bonusSumm;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }

    public Double getLastLat() {
        return lastLat;
    }

    public void setLastLat(Double lastLat) {
        this.lastLat = lastLat;
    }

    public Double getLastLong() {
        return lastLong;
    }

    public void setLastLong(Double lastLong) {
        this.lastLong = lastLong;
    }

    public Date getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(Date lastOnline) {
        this.lastOnline = lastOnline;
    }

    public Long getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Long networkId) {
        this.networkId = networkId;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", networkId=" + networkId +
                ", position=" + position +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", inn='" + inn + '\'' +
                ", phone='" + phone + '\'' +
                ", home='" + home + '\'' +
                ", regdate=" + regdate +
                ", wrongPass=" + wrongPass +
                ", bonusSumm=" + bonusSumm +
                ", isBlocked=" + isBlocked +
                ", isBusy=" + isBusy +
                ", lastLat=" + lastLat +
                ", lastLong=" + lastLong +
                ", lastOnline=" + lastOnline +
                ", currentTaskId=" + currentTaskId +
                '}';
    }
}
