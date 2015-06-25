package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by oleg on 24.06.15.
 * Процессоры(производитель, частота, модель)
 */

@Entity
@Table(name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPU_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vendor vendor;

    @Column(name = "FREQUENCY")
    private Long frequency;

    @Column(name = "Model")
    private String model;

    public CPU() {
    }

    public CPU(Vendor vendor, Long frequency, String model) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Long getFrequency() {
        return frequency;
    }

    public String getModel() {
        return model;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", frequency=" + frequency +
                ", model='" + model + '\'' +
                '}';
    }
}
