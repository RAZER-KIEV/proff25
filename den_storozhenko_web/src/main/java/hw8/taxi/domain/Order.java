package hw8.taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ORDER_ID")
    private Long id;
    @Column(name = "ORDER_DATE")
    private Date date;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Driver driver;
    @Column(name = "AMOUNT")
    private Long amount;
    @Column(name = "ADDRESS_FROM")
    private String addressFrom;
    @Column(name = "ADDRESS_TO")
    private String addressTo;

    public Order() {
    }

    public Order(Date date, Client client, Long amount, String addressFrom, String addressTo) {
        this.date = date;
        this.client = client;
        this.driver = null;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public Order(Long id, Date date, Client client, Long amount, String addressFrom, String addressTo) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.driver = null;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", client=" + client.getFirstname() + " "+ client.getLastname() +
                ", amount=" + amount +
                ", addressFrom='" + addressFrom + '\'' +
                ", addressTo='" + addressTo + '\'' +
                '}';
    }
}
