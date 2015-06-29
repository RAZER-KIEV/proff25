package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by just1ce on 29.06.2015.
 */
@Entity
@Table(name = "STORES")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORE_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @ManyToOne
    private Notebook notebook;
    @Column(name = "STORE_ID")
    private Long id;
    @Column(name = "COUNT")
    private Long count;
    @Column(name = "PRICE")
    private Long price;
    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private Set<Sales> salesSet = new HashSet<>();

    public Store(){

    }

    public Store(Notebook notebook, Long count, Long price) {
        this.notebook = notebook;
        this.count = count;
        this.price = price;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return notebook.toString()+" "+count.toString()+price.toString();
    }

}
