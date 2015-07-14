package hw8.taxi.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Vlad on 12.04.2015.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
    @Id
//    @SequenceGenerator(name = "sequence", sequenceName = "CLIENT_SEQ",
//            allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "ORDER_ID")
    private Long orderId;


    @ManyToOne
    private Client client;

    @Column(name = "ORDER_DATE")
    private Calendar orderDate;

    @Column(name = "ORDER_SUM")
    private Integer orderSum;

    @Column(name = "ADDRESS_FROM")
    private String addressFrom;

    @Column(name = "ADDRESS_TO")
    private String addressTo;

    public Order() {
    }

    public Order(Long id, Client client, Calendar orderDate, Integer sum, String addressFrom, String addressTo) {
        this.orderId = id;
        this.client = client;
        this.orderDate = orderDate;
        this.orderSum = sum;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getClient() {
        return client.getClientName();
    }

    public Client getClientObj() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getOrderDate() {
        if (orderDate == null) {
            return "";
        }
        return SIMPLE_DATE_FORMAT.format(orderDate.getTime());
    }

    public Calendar getOrderDateObj() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
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
}
