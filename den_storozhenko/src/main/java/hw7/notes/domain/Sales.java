package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "SALE_ID")
    private Long id;
    @ManyToOne
    private Store store;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "COUNT")
    private Long count;

    public Sales(){

    }

    public Sales(Store store, Date date, Long count) {
        this.store = store;
        this.date = date;
        this.count = count;
    }

    public Sales(Long id, Store store, Date date, Long count) {
        this.id = id;
        this.store = store;
        this.date = date;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void print(){
        System.out.print(id+" "+date.getDay() + "-" + date.getMonth() + "-" + date.getYear() + " " + count);
        store.print();
    }
}
