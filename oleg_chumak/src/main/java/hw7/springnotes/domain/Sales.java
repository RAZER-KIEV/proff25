package hw7.springnotes.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by oleg on 24.06.15.
 * Продажи(склад ноутбуков, дата продажи, количество)
 */
@Entity
@Table(name = "NOTE_SALES")
public class Sales {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALES_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="SALES_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Store store;

    @Column(name = "SALES_DATE")
    private Date date;

    @Column(name = "SALES_AMOUNT")
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


    public Sales(Store store, String date, Long amount) {

        this.store = store;
        try {
            this.date = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.amount = amount;
    }
}
