package taxi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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
    @Column(name = "PREV_PASSWORD")
    private String previousPassword;
    @Column(name = "LAST_PASSWORD_CHANGE_DATE")
    private LocalDateTime lastPasswordChangeDate;
    @Column(name = "BLOCKED")
    private Boolean isBlocked;
    @Column(name = "UNSUCCESSFUL_LOGIN_TRIES")
    private Long unsuccessfulLoginTries;

    private Role role;

    public Operator(){

    }

    public Operator(String login, String password, Long individualTaxpayerNumber){
        this(login, password, individualTaxpayerNumber, null, null, null, null, null);
    }

    public Operator(String login, String password, Long individualTaxpayerNumber, String previousPassword, LocalDateTime lastPasswordChangeDate, Boolean isBlocked, Long unsuccessfulLoginTries, Role role) {
        this.login = login;
        this.password = password;
        this.individualTaxpayerNumber = individualTaxpayerNumber;
        this.previousPassword = previousPassword;
        this.lastPasswordChangeDate = lastPasswordChangeDate;
        this.isBlocked = isBlocked;
        this.unsuccessfulLoginTries = unsuccessfulLoginTries;
        this.role = role;
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

    public String getPreviousPassword() {
        return previousPassword;
    }

    public void setPreviousPassword(String previousPassword) {
        this.previousPassword = previousPassword;
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

    @Override
    public String toString() {
        return "Operator{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", individualTaxpayerNumber=" + individualTaxpayerNumber +
                ", previousPassword='" + previousPassword + '\'' +
                ", lastPasswordChangeDate=" + lastPasswordChangeDate +
                ", isBlocked=" + isBlocked +
                ", unsuccessfulLoginTries=" + unsuccessfulLoginTries +
                ", role=" + role.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return Objects.equals(getLogin(), operator.getLogin()) &&
                Objects.equals(getPassword(), operator.getPassword()) &&
                Objects.equals(getIndividualTaxpayerNumber(), operator.getIndividualTaxpayerNumber()) &&
                Objects.equals(getPreviousPassword(), operator.getPreviousPassword()) &&
                Objects.equals(getLastPasswordChangeDate(), operator.getLastPasswordChangeDate()) &&
                Objects.equals(getIsBlocked(), operator.getIsBlocked()) &&
                Objects.equals(getUnsuccessfulLoginTries(), operator.getUnsuccessfulLoginTries()) &&
                Objects.equals(getRole(), operator.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getIndividualTaxpayerNumber(), getPreviousPassword(), getLastPasswordChangeDate(), getIsBlocked(), getUnsuccessfulLoginTries(), getRole());
    }
}
