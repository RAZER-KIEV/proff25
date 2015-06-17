package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by oleg on 17.06.15.
 *
 Таблица ноутбуки имеет следующую структуру
 (id, serial, vendor, model, manufacture date, price)
 */

@Entity
@Table(name="NOTEBOOKS")
public class Notebook {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date date;

    @Column(name = "PRICE")
    private Double price;


    public Notebook() {
    }

    public Notebook(String serial, String vendor, String model, Date date, Double price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.date = date;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getSerial() {
        return serial;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public Date getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "\n" +id+ ", " +serial+ ", " +vendor+ "," +model+ "," +date+ "," +price;
    }
}
