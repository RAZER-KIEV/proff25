package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by jax on 05.07.15.
 */
@Entity
@Table(name="store")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "SEQ_STORE_ID", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @Column(name = "STORE_ID")
    private Long id;
    @Column(name="NTEBOOK")
    private Notebook notebook;
    @Column(name="AMOUNT")
    private Integer amount;
    @Column(name="PRICE")
    private Double price;

    public Store(){}
    public Store(Notebook notebook,Integer amount,Double price){
        this.notebook=notebook;
        this.amount=amount;
        this.price=price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }
}
