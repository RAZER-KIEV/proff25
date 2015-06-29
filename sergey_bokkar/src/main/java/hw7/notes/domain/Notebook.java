package hw7.notes.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Well on 29.06.2015
 */

@Entity
@Table(name = "notebooks2")
public class Notebook {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS2_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @ManyToOne
    private Memory memory;

    @ManyToOne
    private CPU cpu;

    public Notebook(){}

    public Notebook(Vendor vendor, String model, LocalDate date, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        manufactureDate = date;
        this.cpu = cpu;
        this.memory = memory;
    }


    public Long getId() {
        return id;
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

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "in work";
    }
}
