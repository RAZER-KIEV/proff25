package taxi.domain;

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
    private Operator operator;

    @ManyToOne
    private TaxiDriver taxiDriver;

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

    public Order(Client client, Operator operator, TaxiDriver taxiDriver, LocalDateTime orderDate,
                 Long amount, String addressFrom, String addressTo) {
        this.client = client;
        this.operator = operator;
        this.taxiDriver = taxiDriver;
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

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public TaxiDriver getTaxiDriver() {
        return taxiDriver;
    }

    public void setTaxiDriver(TaxiDriver taxiDriver) {
        this.taxiDriver = taxiDriver;
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

    @Override
    public String toString() {
        return
                client.getName() +
//                        '|' + operator.getLogin() +
                        '|' + taxiDriver.getName() +
                        '|' + orderDate +
                        '|' + amount +
                        '|' + addressFrom +
                        '|' + addressTo ;
    }
}
