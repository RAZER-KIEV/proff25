package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by just1ce on 16.07.2015.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ORDER_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "ADDRESS_START")
    private String addressStart;
    @Column(name = "ADDRESS_END")
    private String addressEnd;
    @Column(name = "SUM")
    private Long sum;
    @Column(name = "ORDER_DATE")
    private Date date;
    @Column(name = "IDENT")
    private Long id;
    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Order(){}

    public Order(Long id,String addressStart, String addressEnd, Date date, Long sum, Client client) {
        this.addressStart = addressStart;
        this.addressEnd = addressEnd;
        this.date = date;
        this.sum = sum;
        this.client = client;
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAddressStart() {
        return addressStart;
    }

    public void setAddressStart(String addressStart) {
        this.addressStart = addressStart;
    }

    public String getAddressEnd() {
        return addressEnd;
    }

    public void setAddressEnd(String addressEnd) {
        this.addressEnd = addressEnd;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", addressStart='" + addressStart + '\'' +
                ", addressEnd='" + addressEnd + '\'' +
                ", sum=" + sum +
                ", date=" + date +
                ", id=" + id +
                ", client=" + client +
                '}';
    }
}
