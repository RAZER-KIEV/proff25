package hw8.taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Sveta on 8/11/2015.
 * ,
 */
@Component
@Entity
@Table(name="CLIENTS")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CLIENT_ID")
    private Long id;
    private String name;
    private String secondName;
    private String phone;
    private String adress;
    private Double sum;
    private Date lastOrderDay;
    @OneToMany
    List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Client() {
    }

    public Client(String name, String secondName, String phone, String adress) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.adress = adress;
        sum = Double.parseDouble("0");
        lastOrderDay = new Date();
    }

    public Client(String name, String secondName, String phone, String adress, Double summ, Date lastOrderDay) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.adress = adress;
        this.sum = summ;
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

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getLastOrderDay() {
        return lastOrderDay;
    }

    public void setLastOrderDay(Date lastOrderDay) {
        this.lastOrderDay = lastOrderDay;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + adress + '\'' +
                ", sum=" + sum +
                ", lastOrderDay=" + lastOrderDay +
                '}';
    }
}
