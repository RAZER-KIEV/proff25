package hw7.notes.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;

/**
 * Created by viktoria
 * Project:.hw7.domain
 * 1. Создать сущности для базы данных "Магазин ноутбуков":
 * Продажи(склад ноутбуков, дата продажи, количество)
 */

@Entity
@Table (name = "SALES")
public class Sales {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALES_ID", allocationSize = 1, initialValue = 1)

    @Column (name = "ID")
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Store store;

    @Column (name = "MANUFACTURE_DATE")
    private GregorianCalendar manufacture_date;

    @Column (name = "QUANTITY")
    private Integer quantity;

    public Sales(){

    }

    public Sales (Store store, GregorianCalendar manufacture_date, Integer quantity){
        this.store = store;
        this.manufacture_date = manufacture_date;
        this.quantity = quantity;
    }


    public Long getId() {
        return id;
    }

    public GregorianCalendar getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(GregorianCalendar manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
