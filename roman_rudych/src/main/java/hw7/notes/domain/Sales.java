package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Роман on 25.06.2015.
 */
@Entity
@Table(name = "SALES")
public class Sales {

    @Id
    @Column(name = "SALES_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Store", cascade = CascadeType.ALL)
    private Store store;

    @Column(name = "SALES_DATE")
    private Date salesDate;

    @Column(name = "SALES_QUANTITY")
    private int salesQuantity;

    public Sales() {
    }

    public Sales(Store store, Date salesDate, int salesQuantity) {
        this.store = store;
        this.salesDate = salesDate;
        this.salesQuantity = salesQuantity;
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

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}
