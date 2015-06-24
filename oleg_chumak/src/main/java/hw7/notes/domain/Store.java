package hw7.notes.domain;

import javax.persistence.*;
import java.util.Locale;

/**
 * Created by oleg on 24.06.15.
 * Склад ноутбуков(тип ноутбука, количество, цена)
 */
@Entity
@Table(name = "STORE")
public class Store {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORE_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Notebook noteBook;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "PRICE")
    private Long price;

    public Store(Notebook noteBook, Long amount, Long price) {
        this.noteBook = noteBook;
        this.amount = amount;
        this.price = price;
    }

    public Store() {
    }

    public Notebook getNotebook() {
        return noteBook;
    }

    public void setNotebook(Notebook noteBook) {
        this.noteBook = noteBook;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", noteBook=" + noteBook +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    public Long getId() {

        return id;
    }
}
