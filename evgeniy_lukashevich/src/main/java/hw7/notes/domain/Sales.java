package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATE_SALE")
    private Date dateSale;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @ManyToOne
    private Store store;

    public Sales() {

    }

    public Sales (Date dateSale, Integer quantity, Store store){
        this.dateSale = dateSale;
        this.quantity = quantity;
        this.store = store;
    }

    public void setDateSale (Date dateSale) {
        this.dateSale = dateSale;
    }

    public void setQuantity (Integer quantity) {
        this.quantity = quantity;
    }

    public void setStore (Store store) {
        this.store = store;
    }

    public Date getDateSale () {
        return this.dateSale;
    }

    public Integer getQuantity () {
        return this.quantity;
    }

    public Store getStore () {
        return this.store;
    }
}
