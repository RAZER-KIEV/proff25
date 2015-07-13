package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    private Vendor vendor;
    @Column(name = "FREQUENCY")
    private Long frequency;
    @Column(name = "MODEL")
    private String model;

    public CPU () {
    }

    public CPU (Vendor vendor, Long frequency, String model) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    public void setVendor (Vendor vendor) {
        this.vendor = vendor;
    }

    public void setFrequency (Long frequency){
        this.frequency = frequency;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public Long getId () { return this.id; }

    public Vendor getVendor () {
        return this.vendor;
    }

    public Long getFrequency () {
        return this.frequency;
    }

    public String getModel () {
        return this.model;
    }

}
