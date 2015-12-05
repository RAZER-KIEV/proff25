package home.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ПК on 03.12.2015.
 */
@Entity
@Component
public class Technician {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_Technician_ID", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "Technician_ID")
    private Long id;
    private String name;
    private String secondName;
    private String phone;
    private String adress;
    private Double summ;
    private Date lastOrderDay;

    public Technician() {
    }

    public Technician(String name, String secondName, String phone, String adress) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.adress = adress;
        summ = Double.parseDouble("0");
        lastOrderDay = new Date();
    }

    public Technician(String name, String secondName, String phone, String adress, Double summ, Date lastOrderDay) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.adress = adress;
        this.summ = summ;
        this.lastOrderDay = lastOrderDay;
    }

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }

    public Date getLastOrderDay() {
        return lastOrderDay;
    }

    public void setLastOrderDay(Date lastOrderDay) {
        this.lastOrderDay = lastOrderDay;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", summ=" + summ +
                ", lastOrderDay=" + lastOrderDay +
                '}';
    }
}
