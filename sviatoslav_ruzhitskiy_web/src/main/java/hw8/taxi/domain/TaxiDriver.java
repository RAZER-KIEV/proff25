package hw8.taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ПК on 06.08.2015.
 */

@Entity
@Component
public class TaxiDriver {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_TaxiDriver_ID", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "TaxiDriver_ID")
    private Long id;
    private String name;
    private String secondName;
    private String phone;
    private String car;
    private Date regDate;

    public TaxiDriver(String name, String secondName, String phone, String car, Date regDate) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.car = car;
        this.regDate = regDate;
    }

    public TaxiDriver() {}


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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "TaxiDriver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", car='" + car + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
