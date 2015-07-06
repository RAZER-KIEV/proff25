package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jax on 05.07.15.
 */
@Entity
@Table(name="sales")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "SEQ_SALES_ID", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @Column(name = "SALES_ID")
    private Long id;
    @Column(name="STORE")
    private Store store;
    @Column(name="DATE_SALES")
    private Date date;
    @Column(name="AMOUNT")
    private Integer amount;

    public Sales(){
    }
    public Sales(Store store,Date date,Integer amount){
        this.amount=amount;
        this.date=date;
        this.store=store;
    }
}
