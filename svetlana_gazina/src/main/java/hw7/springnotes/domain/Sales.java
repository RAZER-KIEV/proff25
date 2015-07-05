package hw7.springnotes.domain;

import hw7.notes.domain.Store;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sveta on 6/25/2015.
 * склад ноутбуков, дата продажи, количество
 */
@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "SALES_ID")
    private long id;
    @ManyToOne
    private hw7.notes.domain.Store store;
    @Column(name = "DATE_OF_SALE")
    Date dateOfSale;
    Integer amount;

    public Sales() {
    }

    public Sales(hw7.notes.domain.Store store, Date dateOfSale, Integer amount) {
        this.store = store;
        this.dateOfSale = dateOfSale;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public hw7.notes.domain.Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
