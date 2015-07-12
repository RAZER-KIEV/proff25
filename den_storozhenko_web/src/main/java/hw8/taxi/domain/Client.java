package hw8.taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Table(name="CLIENTS")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CLIENTS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CLIENT_ID")
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "SUM")
    private Integer cash;
    @Column(name = "DATE_LAST_ORDER")
    private Date dateLastOrder;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private Set<Order> orderSet = new HashSet<>();

    public Client() {
    }

    public Client(String firstname, String lastname, String phone, String adress, Integer cash, Date dateLastOrder) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.adress = adress;
        this.cash = cash;
        this.dateLastOrder = dateLastOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Date getDateLastOrder() {
        return dateLastOrder;
    }

    public void setDateLastOrder(Date dateLastOrder) {
        this.dateLastOrder = dateLastOrder;
    }

    @Override
    public  String toString(){
        return id+", "+firstname+" "+lastname+", "+phone+", "+adress+", "+cash+", "+dateLastOrder;
    }
}
