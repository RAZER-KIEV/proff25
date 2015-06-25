package hw7.notes.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Sveta on 6/25/2015.
 * Склад ноутбуков(тип ноутбука, количество, цена)
 */
@Entity
@Table(name = "STORES")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "STORES_ID")
    private long id;
    @ManyToMany
    Vendor vendor;
    BigDecimal price;
    Integer amount;
}
