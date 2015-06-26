package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by george on 26.06.15.
 */



@Entity
@Table(name = "SALES")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Store store;

    @Column(name = "SALE_DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "COUNT")
    private Long count;

    public Sales(){

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
}
