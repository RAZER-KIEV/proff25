package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sales")
public class Sales {
    @Id
    @SequenceGenerator(name="sequence", sequenceName="SALES_ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
     private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name ="DATE_SALE")
     private Date saleDate;
    @Column(name ="COUNT")
     private Integer count;

    @ManyToOne
    private Store stor;
//Getters&Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getSaleDate() {
        return saleDate;
    }
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Store getStor() {
        return stor;
    }
    public void setStor(Store stor) {
        this.stor = stor;
    }

    //Конструктора
    public Sales() {
        saleDate=new Date();
        count=100;
        stor=null;
    }
    public Sales(Date saleDate) {
        this.saleDate = saleDate;
        count=100;
        stor=null;
    }
    public Sales(Date saleDate, Integer count) {
        this.saleDate = saleDate;
        this.count = count;
        stor=null;
    }
    public Sales(Date saleDate, Integer count, Store stor) {
        this.saleDate = saleDate;
        this.count = count;
        this.stor = stor;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", count=" + count +
                ", store=" + stor +
                '}';
    }
}
