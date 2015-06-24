package hw7.notes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Stores")
public class Store {
    @Id
    @SequenceGenerator(name="sequence", sequenceName="ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
     private Long id;
    @Column(name ="Count_nb")
     private Long count;
    @Column(name ="Price")
     private Double price;
    private Notebook nb;//класс

//Getters&Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Notebook getNb() {
        return nb;
    }
    public void setNb(Notebook nb) {
        this.nb = nb;
    }

//Конструктора
    public Store() {
        count=100L;
        price=1000.00;
        nb=null;
    }
    public Store(Long count) {
        this.count = count;
        price=1000.00;
        nb=null;
    }
    public Store(Double price, Long count) {
        this.price = price;
        this.count = count;
        nb=null;
    }
    public Store(Long count, Double price, Notebook nb) {
        this.count = count;
        this.price = price;
        this.nb = nb;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", count=" + count +
                ", price=" + price +
                ", nb=" + nb +
                '}';
    }
}
