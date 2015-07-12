package hw8.taxi.domain;

import javax.persistence.*;

// (дата, клиент, сумма, адрес подачи, адрес назначения)
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
    @ManyToOne
    Client client;
    @ManyToOne
    Operator operator;

    public Order() {
    }
    public Order(Double price, String adressCl, String adressDest) {
        this.price = price;
        this.adressCl = adressCl;
        this.adressDest = adressDest;
    }
    public Order(Double price, String adressCl, String adressDest, Client client, Operator operator) {
        this.price = price;
        this.adressCl = adressCl;
        this.adressDest = adressDest;
        this.client = client;
        this.operator = operator;
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
    public Operator getOperator() {
        return operator;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", adressCl='" + adressCl + '\'' +
                ", adressDest='" + adressDest + '\'' +
                ", client=" + client +
                ", operator=" + operator +
                '}';
    }
}
