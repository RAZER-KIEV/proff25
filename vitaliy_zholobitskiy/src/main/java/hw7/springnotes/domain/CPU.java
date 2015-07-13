package hw7.springnotes.domain;



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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private hw7.springnotes.domain.Vendor vendor;
    @OneToMany(mappedBy = "cpu",cascade = CascadeType.ALL)
    private Set<hw7.springnotes.domain.Notebook> ntbkSet = new HashSet<>();


    public CPU() {
    }

    public CPU(hw7.springnotes.domain.Vendor vendor,String cpuFrequency, String model) {
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
    public hw7.springnotes.domain.Vendor getVendor(){
        return vendor;
    }
    public void setVendor(hw7.springnotes.domain.Vendor vendor){
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
