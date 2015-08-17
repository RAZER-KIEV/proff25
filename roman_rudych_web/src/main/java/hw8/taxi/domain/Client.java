package hw8.taxi.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 16.07.2015.
 */
@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CLIENTS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CLIENTS_ID")
    private long id;

    @Column(name = "CLIENT_NAME")
    private String name;

    @Column(name = "CLIENT_LAST_NAME")
    private String lastName;

    @Column(name = "CLIENT_PHONE_NUM")
    private String phoneNum;

    @Column(name = "CLIENT_ADDRESS")
    private String address;

    @Column(name = "CLIENT_SUM")
    private double sum;

    @Column(name = "CLIENT_LAST_ORDER_DATE")
    private Date lastOrderDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    public Client() {
    }

    public Client(String name, String lastName, String phoneNum, String address, double sum, Date lastOrderDate) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
        this.sum = sum;
        this.lastOrderDate = lastOrderDate;
    }

    public Client(String name, String lastName, String phoneNum, String address) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public String toString() {
        return name + " " + lastName + " " + phoneNum + " " + address + " " + sum + " "  +
                new SimpleDateFormat("dd.mm.yy").format(lastOrderDate.getTime()).toString();
    }
}