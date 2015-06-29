package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by george on 26.06.15.
 */
@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    private Notebook notebook;

    @Column(name = "count")
    private Long count;

    @Column(name = "price")
    private Double price;

    public Store() {
    }

    public Store(Notebook notebook, Long count, Double price) {
        this.notebook = notebook;
        this.count = count;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
