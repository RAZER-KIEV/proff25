package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table
public class Sales {
/*
    Продажи:
    -склад ноутбуков,
    -дата продажи,
    -количество.
 */

    private Long id;
    private Store store;
    private Date saleDate;
    private Integer count;

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "STORE")
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    @Column
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    @Column
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString(){
        return new String("SALES store: "+store.getId()+", sales id: "+id+", sales date: "+saleDate+", count: "+
        count+".");
    }
}
