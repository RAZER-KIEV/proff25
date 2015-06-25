package nw7.notes.domain;

import javax.persistence.*;
import java.util.Locale;

/**
 * Created by ПК on 25.06.2015.
 */
@Entity
@Table (name = "STORs")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORS_ID",
        initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    @ManyToOne
    private Notebook notebook;

    private Integer quantity;

    private Double price;

    public Store (){}
    public Store(Notebook notebook, Integer quantity, Double price){
        this.notebook = notebook;
        this.quantity= quantity;
        this.price=price;
    }
    public Long getId(){return id;}
    public Notebook getNotebook() {return notebook;}
    public Integer getQuantity(){return quantity;}
    public Double getPrice(){return price;}
}
