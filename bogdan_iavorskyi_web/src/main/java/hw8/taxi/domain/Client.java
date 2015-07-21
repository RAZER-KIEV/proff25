package hw8.taxi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TOTAL_MONEY_AMOUNT")
    private Long totalMoneyAmount;

    @Column(name = "LAST_ORDER_DATE")
    private LocalDateTime lastOrderDate;

    @ManyToOne
    private Operator operatorLastChanges;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    public Client() {
    }

    public Client(String name, String surname, String phoneNumber, String address, Long totalMoneyAmount, LocalDateTime lastOrderDate, Operator operatorLastChanges) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalMoneyAmount = totalMoneyAmount;
        this.lastOrderDate = lastOrderDate;
        this.operatorLastChanges = operatorLastChanges;
    }

    public Client(Long id, String name, String surname, String phoneNumber, String address, Long totalMoneyAmount, LocalDateTime lastOrderDate, Operator operatorLastChanges) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalMoneyAmount = totalMoneyAmount;
        this.lastOrderDate = lastOrderDate;
        this.operatorLastChanges = operatorLastChanges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTotalMoneyAmount() {
        return totalMoneyAmount;
    }

    public void setTotalMoneyAmount(Long totalMoneyAmount) {
        this.totalMoneyAmount = totalMoneyAmount;
    }

    public LocalDateTime getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(LocalDateTime lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public Operator getOperatorLastChanges() {
        return operatorLastChanges;
    }

    public void setOperatorLastChanges(Operator operatorLastChanges) {
        this.operatorLastChanges = operatorLastChanges;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
