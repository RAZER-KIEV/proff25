package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by oleg on 24.06.15.
 * Продажи(склад ноутбуков, дата продажи, количество)
 */

@Entity
@Table(name = "SALES")
public class Sales {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALES_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Store store;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "AMOUNT")
    private Long amount;

    public Sales() {
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", store=" + store +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }

    public Long getId() {
        return id;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }


    public Sales(Store store, Date date, Long amount) {

        this.store = store;
        this.date = date;
        this.amount = amount;
    }
}
