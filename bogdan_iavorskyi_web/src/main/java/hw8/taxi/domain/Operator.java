package hw8.taxi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OPERATORS")
public class Operator {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_OPERATOR_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "LOGIN", unique = true, nullable = false)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "INDIVIDUAL_TAXPAYER_NUMBER")
    private Long individualTaxpayerNumber;

    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "LAST_PASSWORD_CHANGE_DATE")
    private LocalDateTime lastPasswordChangeDate;

    @Column(name = "BLOCKED")
    private Boolean blocked;

    @Column(name = "UNSUCCESSFUL_LOGIN_TRIES")
    private Integer unsuccessfulLoginTries;

    @OneToMany(mappedBy = "operatorLastChanges", cascade = CascadeType.ALL)
    private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy = "operatorCreated", cascade = CascadeType.ALL)
    private Set<Order> ordersCreatedBy = new HashSet<>();

    @OneToMany(mappedBy = "operatorLastEdit", cascade = CascadeType.ALL)
    private Set<Order> ordersLastEditedBy = new HashSet<>();

    public Operator() {
    }

    public Operator(Long id, String login, String password, Long individualTaxpayerNumber, LocalDateTime registrationDate, LocalDateTime lastPasswordChangeDate, Boolean blocked, Integer unsuccessfulLoginTries) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.individualTaxpayerNumber = individualTaxpayerNumber;
        this.registrationDate = registrationDate;
        this.lastPasswordChangeDate = lastPasswordChangeDate;
        this.blocked = blocked;
        this.unsuccessfulLoginTries = unsuccessfulLoginTries;
    }

    public Operator(String login, String password, Long individualTaxpayerNumber, LocalDateTime registrationDate, LocalDateTime lastPasswordChangeDate, Boolean blocked, Integer unsuccessfulLoginTries) {
        this.login = login;
        this.password = password;
        this.individualTaxpayerNumber = individualTaxpayerNumber;
        this.registrationDate = registrationDate;
        this.lastPasswordChangeDate = lastPasswordChangeDate;
        this.blocked = blocked;
        this.unsuccessfulLoginTries = unsuccessfulLoginTries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIndividualTaxpayerNumber() {
        return individualTaxpayerNumber;
    }

    public void setIndividualTaxpayerNumber(Long individualTaxpayerNumber) {
        this.individualTaxpayerNumber = individualTaxpayerNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getLastPasswordChangeDate() {
        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(LocalDateTime lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Integer getUnsuccessfulLoginTries() {
        return unsuccessfulLoginTries;
    }

    public void setUnsuccessfulLoginTries(Integer unsuccessfulLoginTries) {
        this.unsuccessfulLoginTries = unsuccessfulLoginTries;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Order> getOrdersCreatedBy() {
        return ordersCreatedBy;
    }

    public void setOrdersCreatedBy(Set<Order> ordersCreatedBy) {
        this.ordersCreatedBy = ordersCreatedBy;
    }

    public Set<Order> getOrdersLastEditedBy() {
        return ordersLastEditedBy;
    }

    public void setOrdersLastEditedBy(Set<Order> ordersLastEditedBy) {
        this.ordersLastEditedBy = ordersLastEditedBy;
    }
}
