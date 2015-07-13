package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Store")
public class Store {
    @Id
    @SequenceGenerator(name="sequence", sequenceName="STORE_ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
     private Long id;
    @Column(name ="COUNT_NB")
     private Integer count;
    @Column(name ="Price")
     private Double price;

    @ManyToOne
    private Notebook nBook;
    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "stor" )  // включить двунаправленность
    private Set<Sales> saleSet = new HashSet<>();

//Getters&Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Notebook getNBook() {
        return nBook;
    }
    public void setNBook(Notebook nBook) {
        this.nBook = nBook;
    }
    public Set<Sales> getSaleSet() {
        return saleSet;
    }
    public void setSaleSet(Set<Sales> saleSet) {
        this.saleSet = saleSet;
    }
//Конструктора
    public Store() {
        count=100;
        price=1000.00;
        nBook=null;
    }
    public Store(Integer count) {
        this.count = count;
        price=1000.00;
        nBook=null;
    }
    public Store(Integer count, Double price) {
        this.count = count;
        this.price = price;
        nBook=null;
    }
    public Store(Integer count, Double price, Notebook nBook) {
        this.count = count;
        this.price = price;
        this.nBook = nBook;
    }
    public Store(Integer count, Double price, Notebook nBook, Set<Sales> saleSet) {
        this.count = count;
        this.price = price;
        this.nBook = nBook;
        this.saleSet = saleSet;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", count=" + count +
                ", price=" + price +
                ", nBook=" + nBook +
                '}';
    }
}
