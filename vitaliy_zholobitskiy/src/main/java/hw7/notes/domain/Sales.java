package hw7.notes.domain;

import javax.persistence.*;
import javax.xml.soap.SAAJResult;
import java.util.Date;

/**
 * Created by just1ce on 29.06.2015.
 */
@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALE_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "SALE_ID")
    private Long id;
    @Column(name = "SALE_DATE")
    private Date date;
    @Column(name = "COUNT")
    private Long count;
    @ManyToOne
    private Store store;

    public Sales(){

    }

    public Sales(Store store, Date date, Long count) {
        this.store = store;
        this.date = date;
        this.count = count;
    }


    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

   @Override
    public String toString(){
       return store.toString()+" "+count.toString()+" "+date.toString();
   }
}