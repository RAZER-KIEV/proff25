package hw8.taxi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_ORDER_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Operator operatorCreated;

    @ManyToOne
    private Operator operatorLastEdit;

    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "ADDRESS_FROM")
    private String addressFrom;

    @Column(name = "ADDRESS_TO")
    private String addressTo;

    public Order() {
    }

    public Order(Client client, Operator operatorCreated, Operator operatorLastEdit,
                 LocalDateTime orderDate, Long amount, String addressFrom, String addressTo) {
        this.client = client;
        this.operatorCreated = operatorCreated;
        this.operatorLastEdit = operatorLastEdit;
        this.orderDate = orderDate;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public Order(Long id, Client client, Operator operatorCreated, Operator operatorLastEdit,
                 LocalDateTime orderDate, Long amount, String addressFrom, String addressTo) {
        this.id = id;
        this.client = client;
        this.operatorCreated = operatorCreated;
        this.operatorLastEdit = operatorLastEdit;
        this.orderDate = orderDate;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Operator getOperatorCreated() {
        return operatorCreated;
    }

    public void setOperatorCreated(Operator operatorCreated) {
        this.operatorCreated = operatorCreated;
    }

    public Operator getOperatorLastEdit() {
        return operatorLastEdit;
    }

    public void setOperatorLastEdit(Operator operatorLastEdit) {
        this.operatorLastEdit = operatorLastEdit;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
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
}
