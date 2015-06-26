package hw7.notes.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by oleg on 24.06.15.
 * Тип ноутбука(производитель, модель, дата производства, процессор, память)
 */

@Entity
@Table(name = "NOTE")
public class Notebook {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTE_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PRODUCTION_DATE")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CPU cpu;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Memory memory;

    public Notebook(Vendor vendor, String model, Date date, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.date = date;
        this.cpu = cpu;
        this.memory = memory;
    }


    public Notebook(Vendor vendor, String model, String date, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        try {
            this.date = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.cpu = cpu;
        this.memory = memory;
    }


    public Notebook() {
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
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

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", model='" + model + '\'' +
                ", date=" + date +
                ", cpu=" + cpu +
                ", memory=" + memory +
                '}';
    }
}
