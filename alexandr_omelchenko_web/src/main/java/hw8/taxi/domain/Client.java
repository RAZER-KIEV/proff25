package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CLIENTS")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CL_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstname;
    @Column(name = "LAST_NAME")
    private String lastname;
    @Column(name = "PHONE_NUM")
    private String phone;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "SUM")
    private Integer summ;
    @Column(name = "LAST_ORDER_DATE")
    private Date dateLastOrder;
    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "client" )  // включить двунаправленность
    private Set<Order> orderSet = new HashSet<>();

    public Client() {
    }
    public Client(String firstname, String lastname, String phone, String adress, Integer summ, Date dateLastOrder) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.adress = adress;
        this.summ = summ;
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
    public Date getDateLastOrder() {
        return dateLastOrder;
    }
    public void setDateLastOrder(Date dateLastOrder) {
        this.dateLastOrder = dateLastOrder;
    }
    public Integer getSumm() {
        return summ;
    }
    public void setSumm(Integer summ) {
        this.summ = summ;
    }
    public Set<Order> getOrderSet() {
        return orderSet;
    }
    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", summ=" + summ +
                ", dateLastOrder=" + dateLastOrder +
                ", orderSet=" + orderSet +
                '}';
    }
}
