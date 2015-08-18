package hw8.taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sveta on 8/17/2015.
 */
@Entity
@Component
@Table(name="ORDERs")
public class Order {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ORDER_ID")
    private Long id;
    private Date orderDay;
    @ManyToOne
    private Client client;
    private Double orderSum;
    private String fromAddress;
    private String toAddress;

    public Order() {
    }

    public Order(Long id, Date orderDay, Client client, Double orderSum, String fromAddress, String toAddress) {
        this.id = id;
        this.orderDay = orderDay;
        this.client = client;
        this.orderSum = orderSum;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public Order(Date orderDay, Client client, Double orderSum, String fromAddress, String toAddress) {
        this.orderDay = orderDay;
        this.client = client;
        this.orderSum = orderSum;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Date orderDay) {
        this.orderDay = orderDay;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Double orderSum) {
        this.orderSum = orderSum;
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

    @Override
    public String toString() {
        return "Order:" +
                ", orderDay: " + orderDay +
                ", client: " + client +
                ", orderSum: " + orderSum +
                ", fromAddress: " + fromAddress + '\'' +
                ", toAddress: " + toAddress + '\'' +
                '}';
    }
}
