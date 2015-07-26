package taxi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by GFalcon on 16.07.15.
 */
@Entity
@Table(name = "OPERATORS")
public class Operator {
    @Id
    @Column(name = "LOGIN", nullable = false)
    private String login;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "IND_NUMBER")
    private Long individualTaxpayerNumber;
    @Column(name = "STYLE")
    private String style;
    @Column(name = "LAST_PASSWORD_CHANGE_DATE")
    private LocalDateTime lastPasswordChangeDate;
    @Column(name = "BLOCKED")
    private Boolean isBlocked;
    @Column(name = "UNSUCCESSFUL_LOGIN_TRIES")
    private Long unsuccessfulLoginTries;

    @ManyToOne(cascade = {CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH})
    private Role role;

    @OneToMany(mappedBy = "operator",
            cascade = {CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH})
    private Set<Order> orders;

    public Operator() {

    }

    public Operator(String login, String password, Long individualTaxpayerNumber) {
        this(login, password, individualTaxpayerNumber, null, null, false, null, null);
    }

    public Operator(String login, String password, Long individualTaxpayerNumber,
                    String style, LocalDateTime lastPasswordChangeDate,
                    Boolean isBlocked, Long unsuccessfulLoginTries, Role role) {

        this.login = login;
        this.password = password;
        this.individualTaxpayerNumber = individualTaxpayerNumber;
        this.style = style;
        this.lastPasswordChangeDate = lastPasswordChangeDate;
        this.isBlocked = isBlocked;
        this.unsuccessfulLoginTries = unsuccessfulLoginTries;
        this.role = role;
        orders = new HashSet<>();
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public LocalDateTime getLastPasswordChangeDate() {
        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(LocalDateTime lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Long getUnsuccessfulLoginTries() {
        return unsuccessfulLoginTries;
    }

    public void setUnsuccessfulLoginTries(Long unsuccessfulLoginTries) {
        this.unsuccessfulLoginTries = unsuccessfulLoginTries;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public boolean addOrder(Order order) {
        return this.orders.add(order);
    }

    public boolean removeOrder(Order order) {
        return this.orders.remove(order);
    }

    @Override
    public String toString() {
        return login + '|'
                + password +'|'
                + individualTaxpayerNumber +'|'
                + style + '|'
                + lastPasswordChangeDate + '|'
                + isBlocked + '|'
                + unsuccessfulLoginTries + '|'
                + role.getRoleName()
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return Objects.equals(getLogin(), operator.getLogin()) &&
                Objects.equals(getPassword(), operator.getPassword()) &&
                Objects.equals(getIndividualTaxpayerNumber(), operator.getIndividualTaxpayerNumber()) &&
                Objects.equals(getStyle(), operator.getStyle()) &&
                Objects.equals(getLastPasswordChangeDate(), operator.getLastPasswordChangeDate()) &&
                Objects.equals(getIsBlocked(), operator.getIsBlocked()) &&
                Objects.equals(getUnsuccessfulLoginTries(), operator.getUnsuccessfulLoginTries()) &&
                Objects.equals(getRole(), operator.getRole()) &&
                Objects.equals(getOrders(), operator.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(),
                getPassword(),
                getIndividualTaxpayerNumber(),
                getStyle(),
                getLastPasswordChangeDate(),
                getIsBlocked(),
                getUnsuccessfulLoginTries(),
                getRole(), getOrders());
    }
}
