package hw6.notes;

import javax.persistence.*;
import java.util.Date;

/*Таблица ноутбуки имеет следующую структуру(id, serial, vendor, model, manufacture date, price) */
@Entity
@Table(name="NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name="sequence", sequenceName="SEQ_ID", allocationSize=1, initialValue =5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
    private Long id;
    @Column(name = "SERIAL_NUM")
    private String serial;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "MANUFACTURE_DATE")
    private Date date;
    @Column(name = "PRICE")
    private Double price;
    public Notebook(){
        serial="defoult";
        vendor="Ivan";
        model="defoult";
        date=new Date(115, 12, 5);
        price=1000.00;
    }
    public Notebook(String serial, Double price){
        this.serial=serial;
        this.vendor="Ivan";
        this.model="brandNew";
        this.date=new Date(115, 12, 5);
        this.price=price;
    }
    public Notebook(String serial, String vendor, String model, Date date, Double price){
        this.serial=serial;
        this.vendor=vendor;
        this.model=model;
        this.date=date;
        this.price=price;
    }

    public Long getId() {
        return id;}
    public void setId(Long id) {
        this.id = id;
    }
    public String getSerial() {
        return serial;}
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getVendor() {
        return vendor;}
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getModel() {
        return model;}
    public void setModel(String model) {
        this.model = model;
    }
    public Date getDate() {
        return date;}
    public void setDate(Date date) {
        this.date = date;
    }
    public Double getPrice() {
        return price;}
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';}
}
