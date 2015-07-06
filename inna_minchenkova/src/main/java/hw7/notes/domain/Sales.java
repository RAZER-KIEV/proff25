package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Inna on 28.06.2015.
 */
@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @ManyToOne
    private Store store;

    @Column(name = "SALES_DATE")
    private Date salesDate;

    @Column(name = "AMOUNT")
    private Integer amount;

    public Sales(){

    }

    public Sales(Store store, Date salesDate, Integer amount) {
        this.store = store;
        this.salesDate = salesDate;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", store=" + store +
                ", salesDate=" + salesDate +
                ", amount=" + amount +
                '}';
    }
}
