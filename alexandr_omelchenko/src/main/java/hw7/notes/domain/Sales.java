package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Sales")
public class Sales {
    @Id
    @SequenceGenerator(name="sequence", sequenceName="ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
     private Long id;
    @Column(name ="DATE_SALE")
     private Date saleDate;
    @Column(name ="COUNT")
     private Integer count;
    private Store store;//класс

//Getters&Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getSaleDate() {
        return saleDate;
    }
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }

//Конструктора
    public Sales() {
        saleDate=new Date();
        count=100;
        store=null;
    }
    public Sales(Date saleDate) {
        this.saleDate = saleDate;
        count=100;
        store=null;
    }
    public Sales(Date saleDate, Integer count) {
        this.saleDate = saleDate;
        this.count = count;
        store=null;
    }
    public Sales(Date saleDate, Integer count, Store store) {
        this.saleDate = saleDate;
        this.count = count;
        this.store = store;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", count=" + count +
                ", store=" + store +
                '}';
    }
}
