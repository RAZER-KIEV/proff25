package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name = "STORE")
public class Store {


    private Long id;
    private Notebook notebook;
    private Integer count;
    private Double price;
    private Set<Sales> salesSet = new HashSet<>();

    public Store() {
        this(new Notebook(), 10, 500D);
    }

    public Store(Notebook notebook, Integer count, Double price) {
        this.notebook = notebook;
        this.count = count;
        this.price = price;
    }

    public Store(Store store) {
        this.notebook = store.getNotebook();
        this.count = store.getCount();
        this.price = store.getPrice();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    @Column(name = "store_count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Column(name = "price_count")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    public Set<Sales> getSalesSet() {
        return salesSet;
    }

    public void setSalesSet(Set<Sales> salesSet) {
        this.salesSet = salesSet;
    }

    @Override
    public String toString() {
        return new String("STORE id: " + id + ", Notebook type: " + notebook + ", count: " + count +
                ", price: " + price + ".");
    }
}
