package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STORES")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORES_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "STORE_ID")
    private Long id;
    @Column(name = "COUNT")
    private Long count;
    @Column(name = "PRICE")
    private Double price;
    @ManyToOne
    private Notebook notebook;
    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private Set<Sales> salesSet = new HashSet<>();

    public Store(){

    }

    public Store(Notebook notebook, Long count, Double price) {
        this.notebook = notebook;
        this.count = count;
        this.price = price;
    }

    public Store(Long id, Notebook notebook, Long count, Double price) {
        this.id = id;
        this.notebook = notebook;
        this.count = count;
        this.price = price;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void print(){
        System.out.print(id+" "+count+" "+price);
        notebook.print();
    }
}
