package hw8.taxi.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

/**
 * Created by Vlad on 05.04.2015.
 */
@Entity
@Table(name = "CLIENTS")
public class Client {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CLIENT_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "CLIENT_ID")
    private Long clientID;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_SURNAME")
    private String clientSurname;

    @Column(name = "CLIENT_PHONE")
    private String clientPhone;

    @Column(name = "CLIENT_ADDRESS")
    private String clientAddress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    @Fetch(FetchMode.SELECT)
    private Set<Order> clientTotalOrders;

    @Column(name = "CLIENT_AMOUNT")
    private Integer clientAmount;

    @Column(name = "CLIENT_ORDER_DATE")
    private Calendar clientOrderDate;


    public Client(String clientName, String clientSurname, String clientAddress, Integer amount, String clientPhone) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientAddress = clientAddress;
        this.clientAmount = amount;
        this.clientPhone = clientPhone;
        this.clientOrderDate = new GregorianCalendar();
    }

    public Integer getClientAmount() {
        return clientAmount;
    }

    public void setClientAmount(Integer clientAmount) {
        this.clientAmount = clientAmount;
    }

    public Client() {
    }

    public void addOrder(Order order) {
        clientTotalOrders.add(order);
    }


    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public Set<Order> getClientTotalOrders() {
        return clientTotalOrders;
    }

    public void setClientTotalOrders(Set<Order> clientTotalOrders) {
        this.clientTotalOrders = clientTotalOrders;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientOrderDate() {
        if (clientOrderDate == null) {
            return "";
        }
        return SIMPLE_DATE_FORMAT.format(clientOrderDate.getTime());
    }

    public Calendar getClientDate() {
        return clientOrderDate;
    }


    public void setClientOrderDate(Calendar clientOrderDate) {
        this.clientOrderDate = clientOrderDate;
    }
}
