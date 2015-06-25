package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name="STORE")
public class Store {
    /*
    Склад ноутбуков:
    -тип ноутбука,
    -количество,
    -цена.
     */

    private Long id;
    private Notebook notebook;
    private Integer count;
    private Double price;

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
    @JoinTable(name="NOTEBOOK")
    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }
    @Column
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    @Column
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return new String("STORE id: "+id+", Notebook type: "+notebook+", count: "+count+
        ", price: "+price+".");
    }
}
