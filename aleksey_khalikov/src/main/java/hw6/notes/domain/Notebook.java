package hw6.notes.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by GFalcon on 17.06.15.
 */
@Entity
@Table(name="NOTEBOOK")
public class Notebook {
    @SequenceGenerator(name = "myseq", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "SERIAL")
    private String serial;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "model")
    private String model;
    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;
    @Column(name = "PRICE")
    private Double price;

    public Notebook(){
        this(null, null, null, null, null);
    }

    public Notebook(String serial, String vendor, String model, Date manufactureDate, Double price){
        this(null, serial, vendor, model, manufactureDate, price);
    }

    public Notebook(Long id, String serial, String vendor, String model, Date manufactureDate, Double price){
        setId(id);
        setSerial(serial);
        setVendor(vendor);
        setModel(model);
        setManufactureDate(manufactureDate);
        setPrice(price);
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String mdate = dateFormat.format(getManufactureDate());
        return getVendor() + " " + getModel() + " SN: " + getSerial() + " manuf. " + mdate + "\t price: " + getPrice();
    }
}
