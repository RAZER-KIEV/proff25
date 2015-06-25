package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Роман on 25.06.2015.
 */

@Entity
@Table(name = "STORE")
public class Store {

    @Id
    @Column(name = "STORE_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "STORE_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @OneToMany(mappedBy = "Notebook")
    private Notebook notebookType;

    @Column(name = "STORE_NTB_QUANTITY")
    private int notebooksQuantity;

    @Column(name = "STORE_PRICE")
    private double price;

    public Store () {
    }

    public Store(Notebook notebookType, int notebooksQuantity, double price) {
        this.notebookType = notebookType;
        this.notebooksQuantity = notebooksQuantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNotebooksQuantity() {
        return notebooksQuantity;
    }

    public void setNotebooksQuantity(int notebooksQuantity) {
        this.notebooksQuantity = notebooksQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Notebook getNotebookType() {
        return notebookType;
    }

    public void setNotebookType(Notebook notebookType) {
        this.notebookType = notebookType;
    }
}
