package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Создать DAO для таблицы ноутбуки
 * Таблица ноутбуки имеет следующую структуру
 * (id, serial, vendor, model, manufacture date, price)
 * domain
 * hw6.notes.domain.Notebook
 * dao
 * hw6.notes.dao.NotebookDao
 * Long create(Notebook ntb)
 * Notebook read(Long ig)
 * boolean update(Notebook ntb)
 * boolean delete(Notebook ntb)
 * List<Notebook> findAll()
 * hw6.notes.dao.NotebookDaoImpl
 */
@Entity
@Table(name = "NOTEBOOK")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private Long id;

    private String serial;
    private String vendor;
    private String model;

    @Temporal(TemporalType.DATE)
    @Column(name = "MANUFACTURE_DATE")
    private Date date;

    private Double price;

    public Notebook() {

    }

    public Notebook(String serial, String vendor, String model, Date date, Double price ) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "Notebook {" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", model='" + model + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
