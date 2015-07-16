package taxi.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "Client_name")
    private String name;

    @Column(name  = "Client_surname")
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "client_address")
    private String address;

    @Column(name = "money")
    private Long totalMoneyAmount;

    @Column(name = "last_order")
    private LocalDateTime lastOrderDate;


    @OneToMany(mappedBy = "client",
            cascade = {CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH})
    private Set<Order> orders;

    public Client() {
    }

    public Client(String name, String surname, String phoneNumber, String address, Long totalMoneyAmount, LocalDateTime lastOrderDate, Set<Order> orders) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalMoneyAmount = totalMoneyAmount;
        this.lastOrderDate = lastOrderDate;
        this.orders = orders;
    }

    public Client(String name, String surname, String phoneNumber, String address) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}


