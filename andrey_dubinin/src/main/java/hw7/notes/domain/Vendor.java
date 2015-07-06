package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by jax on 05.07.15.
 */
@Entity
@Table(name="vendor")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "SEQ_VENDOR_ID", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @Column(name = "VENDOR_ID")
    private Long id;
    @Column(name="NAME")
    private String name;

    public Vendor(){

    }

    public Vendor(String name){
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}
