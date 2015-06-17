package session10;

import javax.persistence.*;

/**
 * Created by ivan on 15.06.15.
 */

@Entity
@Table(name="REGIONS")
public class Region {


    private Long id;


    private String name;

    public Region(){

    }

    public Region(String name){
        this.name=name;
    }

    public void setId(long id){
    this.id=id;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")
    public Long getId(){
    return this.id;
    }

    public void setName(String name){
        this.name=name;
    }

    @Column(name="REGION_NAME")
    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return new String("Region name: "+name+"; Region id: "+id+" ");
    }

}
