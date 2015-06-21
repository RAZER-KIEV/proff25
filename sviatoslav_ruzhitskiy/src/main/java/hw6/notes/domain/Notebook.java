package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.DoubleSummaryStatistics;

/**
 *
 *  Создать DAO для таблицы ноутбуки
 Таблица ноутбуки имеет следующую структуру
 (id, serial, vendor, model, manufacture date, price)
 domain
 Notebook
 dao
 hw6.notes.dao.NotebookDao
 Long create(Notebook ntb)
 Notebook read(Long ig)
 boolean update(Notebook ntb)
 boolean delete(Notebook ntb)
 List<Notebook> findAll()
 hw6.notes.dao.NotebookDaoImpl
 * Created by ПК on 18.06.2015."
 */
@Entity
@Table(name = "NOTEBOOKS" )

public class Notebook {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "SERIAL_NUMBER")
    private String serial;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "MODEL")
    private String model;
    @Column(name =  "MANUFACTURE_DATE")
    private Date manufacture_date;
    @Column(name = "PRICE")
    private Double price;

    public Notebook(){}
    public Notebook(String ser, String vend, String mod, Date m_date, Double prc){
        serial =ser;
        vendor = vend;
        model = mod;
        manufacture_date = m_date;
        price = prc;
    }
    public Notebook(Long id, String ser, String vend, String mod, Date m_date, Double prc){
        serial =ser;
        vendor = vend;
        model = mod;
        manufacture_date = m_date;
        price = prc;
        this.id = id;
    }

    public Long getId(){return id;}

    public String getSerial(){return serial;}
    public void setSerial(String ser){serial =ser;}

    public String getVendor(){return  vendor;}
    public void setVendor(String vend){vendor=vend;}

    public String getModel(){return  model;}
    public void setModel(String modl){model = modl;}

    public Date getManufacture_date(){return manufacture_date;}
    public void setManufacture_date(Date dt){manufacture_date = dt;}

    public Double getPrice(){return price;}
    public void setPrice(Double prc){price = prc;}

    @Override
    public String toString(){
        return "\n" +id+ ", " +serial+ ", " +vendor+ "," +model+ "," +manufacture_date+ "," +price;
    }

}
