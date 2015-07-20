package hw8.taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ПК on 15.07.2015.
 * дата, клиент, сумма, адрес подачи, адрес назначения
 *
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
    private String departureAddress;
    private String destinationAddress;

    public Order() {
    }

    public Order(Long id, Date orderDay, Client client, Double orderSum, String departureAddress, String destinationAddress) {
        this.id = id;
        this.orderDay = orderDay;
        this.client = client;
        this.orderSum = orderSum;
        this.departureAddress = departureAddress;
        this.destinationAddress = destinationAddress;
    }

    public Order(Date orderDay, Client client, Double orderSum, String departureAddress, String destinationAddress) {
        this.orderDay = orderDay;
        this.client = client;
        this.orderSum = orderSum;
        this.departureAddress = departureAddress;
        this.destinationAddress = destinationAddress;
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

    public String getDepartureAddress() {
        return departureAddress;
    }

    public void setDepartureAddress(String departureAddress) {
        this.departureAddress = departureAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDay=" + orderDay +
                ", client=" + client +
                ", orderSum=" + orderSum +
                ", departureAddress='" + departureAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                '}';
    }
}
