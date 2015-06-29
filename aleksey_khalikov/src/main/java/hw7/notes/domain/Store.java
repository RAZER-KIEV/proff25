package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by GFalcon on 24.06.15.
 *
 * Склад ноутбуков(тип ноутбука, количество, цена)
 */
@Entity
@Table(name = "STORE")
public class Store {

    @Id
    @SequenceGenerator(name = "myseq", sequenceName = "SEQ_STORE", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
//    @Column(name = "NOTEBOOK")
    private Notebook notebook;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "PRICE")
    private Double price;

    @OneToMany(mappedBy = "store",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REFRESH,
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH})
    private Set<Sales> salesSet;

    public Store() {
        this(null, 0, 0.);
    }

    public Store(Notebook notebook, int amount, double price){
        salesSet = new HashSet<Sales>();
        this.setNotebook(notebook);
        this.setAmount(amount);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", notebook=" + notebook.toString() +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(id, store.id) &&
                Objects.equals(notebook, store.notebook) &&
                Objects.equals(amount, store.amount) &&
                Objects.equals(price, store.price) &&
                Objects.equals(salesSet, store.salesSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, notebook, amount, price, salesSet);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Sales> getSalesSet() {
        return salesSet;
    }

    public void setSalesSet(Set<Sales> salesSet) {
        this.salesSet = salesSet;
    }

    public void addSale(Sales sale){
        this.salesSet.add(sale);
    }
}
