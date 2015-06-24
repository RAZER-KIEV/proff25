package hw6.notes.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Роман on 18.06.2015.
 */

@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private long id;

    @Column(name = "NOTEBOOK_SERIAL")
    private String serial;

    @Column(name = "NOTEBOOK_VENDOR")
    private String vendor;

    @Column(name = "NOTEBOOK_MODEL")
    private String model;

    @Column(name = "NOTEBOOK_MANUFACT_DATE")
    private Date manufactureDate;

    @Column(name = "NOTEBOOK_PRICE")
    private Double price;

    public Notebook() {}

    public Notebook(String serial, String vendor, String model, String DateddMMyyyy, Double price) throws ParseException {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        this.manufactureDate = sdf.parse(DateddMMyyyy);
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String toString() {
        StringBuilder sb = new StringBuilder("                                                               ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sb.insert(0, id + " ").insert(6, serial + " ").insert(30, vendor + " ").
                insert(40, model + " ").insert(55, sdf.format(manufactureDate.getTime()) + " ").
                insert(70, price).toString();
    }
}
