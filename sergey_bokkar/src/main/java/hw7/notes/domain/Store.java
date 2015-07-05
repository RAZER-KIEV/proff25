package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Well on 29.06.2015
 */
@Entity
@Table(name = "store")
public class Store {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORE_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "store_price")
    private Double price;

    @ManyToOne
    private Notebook notebook;

    @Column(name = "store_quantity")
    private Integer quantity;

    public Store(){}

    public Store(Double price, Integer quantity, Notebook ntb){
        this.price = price;
        this.quantity = quantity;
        notebook = ntb;
    }

    public Long getStoreId() {
        return storeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
