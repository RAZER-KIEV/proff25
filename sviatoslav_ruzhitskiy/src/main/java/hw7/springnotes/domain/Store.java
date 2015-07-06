package hw7.springnotes.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ПК on 25.06.2015.
 */
@Component
@Entity
@Table (name = "STORs")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORS_ID",
        initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE })
    private Notebook notebook;

    private Integer quantity;

    private Double price;

    public Store (){}
    public Store(Notebook notebook, Integer quantity, Double price){
        this.notebook = notebook;
        this.quantity= quantity;
        this.price=price;
    }
    public Long getId(){
        return id;
    }
    public Notebook getNotebook() {
        return notebook;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer qu){
        quantity = qu;
    }
    public Double getPrice(){
        return price;
    }
}
