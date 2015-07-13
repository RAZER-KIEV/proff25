package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Well on 29.06.2015
 */

@Entity
@Table(name = "cpu")
public class CPU {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "cpu_id")
    private Long cpuId;

    @ManyToOne
    private Vendor vendor;

//    @Column(name = "cpu_vendor")
//    private String cpuVendor;

    @Column(name = "cpu_model")
    private String cpuModel;

    @Column(name = "cpu_frequency")
    private Long cpuFreq;

    public CPU(){}

    public CPU (Vendor vendor, Long cpuFreq, String cpuModel){
        this.cpuFreq = cpuFreq;
        this.cpuModel = cpuModel;
        this.vendor = vendor;
    }

    public Long getId() {
        return cpuId;
    }

    public Vendor getCpuVendor() {
        return vendor;
    }

    public void setCpuVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public Long getCpuFreq() {
        return cpuFreq;
    }

    public void setCpuFreq(Long cpuFreq) {
        this.cpuFreq = cpuFreq;
    }
}
