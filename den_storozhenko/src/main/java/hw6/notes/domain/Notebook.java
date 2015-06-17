package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NTB_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private Long id;
    @Column(name = "SERIAL")
    private String serial;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "MANUFACT_DATE")
    private Date manufacture_date;
    @Column(name = "PRICE")
    private Double price;

    public Notebook(){
    }

    public Notebook(String serial, String vendor, String model, Date manufacture_date, Double price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufacture_date = manufacture_date;
        this.price = price;
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

    public void setManufacture_date(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public void setPrice(Double price) {
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

    public Date getManufacture_date() {
        return manufacture_date;
    }

    public Double getPrice() {
        return price;
    }

    public void print(){
        System.out.println("Notebook: "+id+" "+serial+" "+vendor+" "+model+" "+manufacture_date+" "+price);
    }
}
