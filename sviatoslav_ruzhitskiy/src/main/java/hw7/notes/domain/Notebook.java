package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 1. Создать сущности для базы данных "Магазин ноутбуков":
 Тип ноутбука(производитель, модель, дата производства, процессор, память)
 Производители(имя)
 Процессоры(производитель, частота, модель)
 Память(производитель, размер)
 Склад ноутбуков(тип ноутбука, количество, цена)
 Продажи(склад ноутбуков, дата продажи, количество)

 domain
 hw7.notes.domain.Notebook
 hw7.notes.domain.Vendor
 hw7.notes.domain.CPU
 hw7.notes.domain.Memory
 hw7.notes.domain.Store
 hw7.notes.domain.Sales
 * Created by ПК on 25.06.2015.
 */
@Entity
@Table(name = "NOTEBOOKS2" )

public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS2_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE })
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE })
    private CPU cpu;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE })
    private Memory memory;

    private String model;

    private Date manuf_date;

    public Notebook(){}

    public Notebook(Vendor vendor,CPU cpu,Memory memory, String model,Date manuf_date){
        this.vendor = vendor;
        this.cpu = cpu;
        this.memory = memory;
        this.model = model;
        this.manuf_date =manuf_date;
    }
    public Long getId(){
        return id;
    }
    public Vendor getVendor(){

        return vendor;
    }
    public CPU getCPU(){
        return cpu;
    }
    public Memory getMemory(){
        return memory;
    }
    public String getModel(){
        return model;
    }
    public Date getManuf_date(){
        return manuf_date;
    }
    public String toString(){
        return "NOTEBOOK. id: "+getId()+"; CPU: "+getCPU()+"; Memory: "+getMemory()+"; Model: "+getModel()+"; manuf_date: "+getManuf_date();
    }
}
