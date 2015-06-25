package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name="MEMORY")
public class Memory {
    /*
    Память:
    -производитель,
    -размер.
     */

    private Long id;
    private String producer;
    private Integer size;

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    @Column
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return new String("MEMORY id: "+id+", memory producer: "+producer+", memory size: "+size+".");
    }
}
