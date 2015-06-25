package nw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ПК on 25.06.2015.
 */
@Entity
@Table(name = "SALEs")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SQLEs_ID",
    allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    private Store store;

    private Date sale_date;

    private Integer quantity;

    public Sales(){}
    public Sales(Store store, Date sale_date, Integer quantity){
        this.store=store;
        this.sale_date = sale_date;
        this.quantity= quantity;
    }
    public Long getId(){return id;}
    public Store getStore(){return store;}
    public Date getSale_date(){return sale_date;}
    public Integer getQuantity(){return quantity;}
    }
