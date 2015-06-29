package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
@Entity
@Table(name = "STORE")
public class Store {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORE_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    private Notebook notebook;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "PRICE")
    private Double price;

    public Store() {

    }

    public Store (Notebook notebook, Integer quantity, Double price) {
        this.notebook = notebook;
        this.quantity = quantity;
        this.price = price;
    }

    public void setNotebook (Notebook notebook) { this.notebook = notebook; }

    public void setQuantity (Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice (Double price) {
        this.price = price;
    }

    public Long getId () {
        return this.id;
    }

    public Notebook getNotebook () {
        return this.notebook;
    }

    public Integer getQuantity () {
        return this.quantity;
    }

    public Double getPrice () {
        return this.price;
    }
}
