package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//имя, фамилия, телефон, адрес, сумма, дата последнего заказа
/**
 * Created by just1ce on 16.07.2015.
 */
@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CLIENT_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CLIENT_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "SUM")
    private Long sum;
    @Column(name = "DATE_LAST_ORDER")
    private Date dateLastOrder;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private Set<Order> ordersSet = new HashSet<>();

    public Client(Date dateLastOrder, Long sum, String address, String surname, String name, String phoneNumber) {
        this.dateLastOrder = dateLastOrder;
        this.sum = sum;
        this.address = address;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public Client(){}
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return surname;
    }

    public void setPass(String pass) {
        this.surname = surname;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateLastOrder() {
        return dateLastOrder;
    }

    public void setDateLastOrder(Date dateLastOrder) {
        this.dateLastOrder = dateLastOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + "  " + surname + ", " + address + ", " + phoneNumber + ", " + sum + ", " + dateLastOrder;
    }
}
