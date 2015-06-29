package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by just1ce on 29.06.2015.
 */
@Entity
@Table(name = "CPUS")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CPU_ID")
    private Long id;
    @Column(name = "CPU_FREQUENCY")
    private String cpuFrequency;
    @Column(name = "MODEL")
    private String model;
    @ManyToOne
    private Vendor vendor;
    @OneToMany(mappedBy = "cpu",cascade = CascadeType.ALL)
    private Set<Notebook> ntbkSet = new HashSet<>();


    public CPU() {
    }

    public CPU(Vendor vendor,String cpuFrequency, String model) {
        this.cpuFrequency = cpuFrequency;
        this.vendor=vendor;
        this.model = model;
    }


    public String getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(String cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }
    public Vendor getVendor(){
        return vendor;
    }
    public void setVendor(Vendor vendor){
        this.vendor=vendor;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return model+" "+cpuFrequency+" "+vendor.toString();
    }
}
