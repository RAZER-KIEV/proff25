package hw6.notes.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by viktoria
 * Project:.hw6.notes
 * Создать DAO для таблицы ноутбуки
 Таблица ноутбуки имеет следующую структуру (id, serial, vendor, model, manufacture date, price)
 */

@Entity
@Table  (name = "NOTEBOOK")
public class Notebook {

    @Id
    @SequenceGenerator(name= "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column (name = "ID")
    private Long id;

    @Column (name = "SERIAL")
    private String serial;

    @Column (name = "VENDOR")
    private String vendor;

    @Column (name = "MODEL")
    private String model;

    @Column (name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @Column (name = "PRICE")
    private double price;

    public Notebook(){

    }

    public Notebook(String serial, String vendor, String model, Date manufactureDate, double price){

        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this. manufactureDate = manufactureDate;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Notebook: \n" + id + "\n" + serial + "\n" + vendor + "\n" + model + "\n" + manufactureDate + "\n" +price + "\n";

    }
}
