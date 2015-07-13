package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by GFalcon on 24.06.15.
 *
 * Продажи(склад ноутбуков, дата продажи, количество)
 */
@Entity
@Table(name = "SALES")
public class Sales {

    @Id
    @SequenceGenerator(name = "myseq", sequenceName = "SEQ_SALES", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
 //   @Column(name = "STORE")
    private Store store;

    @Column(name = "SDATE")
    private Date date;

    @Column(name = "AMOUNT")
    private Integer amount;

    public Sales(){

    }

    public Sales(Store store, int amount){
        Date currentDate = new Date();
        long dt = currentDate.getTime();
        this.date = new Date(dt);

        this.store = store;
        this.amount = amount;
    }

    public Sales(Store store, Date date, int amount){
        this.store = store;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", store=" + store.toString() +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return Objects.equals(id, sales.id) &&
                Objects.equals(store, sales.store) &&
                Objects.equals(date, sales.date) &&
                Objects.equals(amount, sales.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, store, date, amount);
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
