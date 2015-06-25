package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sveta on 6/25/2015.
 * склад ноутбуков, дата продажи, количество
 */
@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "SALES_ID")
    private long id;
    @ManyToOne
    private Store store;
    @Column(name = "DATE_OF_SALE")
    Date dateOfSale;
    Integer amount;

}
