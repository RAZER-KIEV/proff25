package hw7.springnotes.domain;

import hw7.notes.domain.Vendor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Sveta on 6/25/2015.
 * Склад ноутбуков(тип ноутбука, количество, цена)
 */
@Entity
@Table(name = "STORES")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "STORES_ID")
    private long id;
    @ManyToOne
    hw7.notes.domain.Vendor vendor;
    BigDecimal price;
    Integer amount;

    public Store() {
    }

    public Store(hw7.notes.domain.Vendor vendor, BigDecimal price, Integer amount) {
        this.vendor = vendor;
        this.price = price;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public hw7.notes.domain.Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
