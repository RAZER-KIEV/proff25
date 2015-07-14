package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ORDER_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "ADRESS_CLIENT")
    private String adressCl;
    @Column(name = "ADRESS_DESTINATION")
    private String adressDest;
    @Column(name = "ORDER_DATE")
    private Date date;
    @ManyToOne
    Client client;

    public Order() {
    }
    public Order(Double price, String adressCl, String adressDest) {
        this.price = price;
        this.adressCl = adressCl;
        this.adressDest = adressDest;
        this.date=new Date();
    }

    public Order(Double price, String adressCl, String adressDest, Date date, Client client) {
        this.price = price;
        this.adressCl = adressCl;
        this.adressDest = adressDest;
        this.date = date;
        this.client = client;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getAdressCl() {
        return adressCl;
    }
    public void setAdressCl(String adressCl) {
        this.adressCl = adressCl;
    }
    public String getAdressDest() {
        return adressDest;
    }
    public void setAdressDest(String adressDest) {
        this.adressDest = adressDest;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", adressCl='" + adressCl + '\'' +
                ", adressDest='" + adressDest + '\'' +
                ", date=" + date +
                ", client=" + client +
                '}';
    }
}
