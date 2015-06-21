package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.DoubleSummaryStatistics;

@Entity
@Table(name="NOTEBOOKS")
public class Notebook {

    private Long id;
    private String serial;
    private String vendor;
    private String model;
    private Date manufactureDate;
    private Double price;

    public Notebook(){

    }

    public Notebook(String serial, String vendor, String model, Date manufactureDate, Double price){
        this.serial=serial;
        this.vendor=vendor;
        this.model=model;
        this.manufactureDate=manufactureDate;
        this.price=price;
    }

    public Notebook(Notebook notebook){
        this.id=notebook.id;
        this.serial=notebook.serial;
        this.vendor=notebook.vendor;
        this.model=notebook.model;
        this.manufactureDate=notebook.manufactureDate;
        this.price=notebook.price;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="SERIAL")
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Column(name="VENDOR")
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Column(name="MODEL")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name="MANUFACTURE_DATE")
    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Column(name="PRICE")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return new String("Notebook id: "+id+"; serial: "+serial+"; vendor: "+vendor
                +"; model: "+model+"; manufacture date: "+manufactureDate+"; price: "+price+".");
    }
}
