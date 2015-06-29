package hw7.notes.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Well on 29.06.2015.
 */
public class Sales {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "sales_id")
    private Long salesId;

    @Column(name = "sales_date")
    private LocalDate salesDate;

    @Column(name = "sales_quantity")
    private Long salesQuantity;

    @ManyToOne
    private Store store;

    public Sales(){}

    public Sales (LocalDate salesDate, Long salesQuantity, Store store){
        this.salesDate = salesDate;
        this.salesQuantity = salesQuantity;
        this.store = store;
    }

    public Long getSalesId() {
        return salesId;
    }

    public LocalDate getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(LocalDate salesDate) {
        this.salesDate = salesDate;
    }

    public Long getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Long salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
