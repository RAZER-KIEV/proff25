package hw7.notes.domain;

import org.aspectj.weaver.ast.Not;
import scala.Int;

import javax.persistence.*;

/**
 * Created by viktoria
 * Project:.hw7.domain
 * 1. Создать сущности для базы данных "Магазин ноутбуков":
 * Склад ноутбуков(тип ноутбука, количество, цена)
 */

@Entity
@Table (name = "STORE")
public class Store {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORE_ID", allocationSize = 1, initialValue = 1)

    @Column (name = "ID")
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Notebook notebook;

    @Column (name = "QUANTITY")
    private Integer quantity;

    @Column (name = "PRICE")
    private Double price;

    public Store (){

    }

    public Store (Notebook notebook, Integer quantity, Double price){
        this.notebook = notebook;
        this.quantity = quantity;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }
}
