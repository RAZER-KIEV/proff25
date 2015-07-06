package hw7.notes.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Inna on 27.06.2015.
 */
@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CPU_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "CPU_FREQUENCY")
    private String frequency;

    @Column(name = "CPU_MODEL")
    private String model;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cpu")
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebookSet;

    public CPU(){

    }

    public CPU(Vendor vendor, String frequency, String model) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", frequency='" + frequency + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
