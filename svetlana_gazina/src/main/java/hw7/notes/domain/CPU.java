package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Sveta on 6/25/2015.
 * Процессоры(производитель, частота, модель)
 */
@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPU_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CPU_ID")
    private long id;
    @ManyToOne
    private Vendor vendor;
    private String model;
    @Column(name = "CLOCK_RATE")
    private Integer clockRate;

    public CPU() {
    }

    public CPU(Vendor vendor, String model, Integer clockRate) {
        this.vendor = vendor;
        this.model = model;
        this.clockRate = clockRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getClockRate() {
        return clockRate;
    }

    public void setClockRate(Integer clockRate) {
        this.clockRate = clockRate;
    }
}
