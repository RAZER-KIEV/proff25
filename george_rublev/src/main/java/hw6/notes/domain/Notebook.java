package hw6.notes.domain;

import javax.persistence.*;

/**
 * Created by george on 19.06.15.
 */
@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private String manufactureDate;

    @Column(name = "PRICE")
    private double price;

    public Notebook(String serial, String vendor, String model, String manufactureDate, double price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public Notebook() {
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

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void print(){
        System.out.println("Notebook: "+id+" "+serial+" "+vendor+" "+model+" "+manufactureDate+" "+price);
    }
}
