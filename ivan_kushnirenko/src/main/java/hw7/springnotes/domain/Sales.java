package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name = "SALES")
public class Sales {

    private Long id;
    private Store store;
    private Date saleDate;
    private Integer count;

    public Sales() {
        this(new Store(), new Date(), 0);
    }

    public Sales(Store store, Date saleDate, Integer count) {
        this.store = store;
        this.saleDate = saleDate;
        this.count = count;
    }

    public Sales(Sales sales) {
        this.id = sales.getId();
        this.store = sales.getStore();
        this.saleDate = sales.getSaleDate();
        this.count = sales.getCount();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Column(name = "sales_date")
    @Temporal(TemporalType.DATE)
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new String("SALES store: " + store.getId() + ", sales id: " + id + ", sales date: " + saleDate + ", count: " +
                count + ".");
    }
}
