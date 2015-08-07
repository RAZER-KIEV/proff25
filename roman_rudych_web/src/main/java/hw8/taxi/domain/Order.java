package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Роман on 04.08.2015.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ORDERS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ORDER_ID")
    private long id;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @ManyToOne
    private Client client;

    @Column(name = "ORDER_SUM")
    private Double sum;

    @Column(name = "ORDER_FROM")
    private String fromAddress;

    @Column(name = "ORDER_TO")
    private String toAddress;

    public Order() {
    }

    public Order(Date orderDate, Client client, Double sum, String fromAddress, String toAddress) {
        this.orderDate = orderDate;
        this.client = client;
        this.sum = sum;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String toString() {
        return id + " | " + orderDate + " | " + client.getPhoneNum() + " | " + sum + " | " + fromAddress + " | " + toAddress;
    }
}
