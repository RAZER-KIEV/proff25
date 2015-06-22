package session10;

import javax.persistence.*;

/**
 * Created by Jeckgehor on 16.06.2015.
 */
@Entity
@Table(name = "REGIONS")
class Region {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID", allocationSize = 1, initialValue = 9)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "REGION_ID")
    private long id;
    @Column (name = "REGION_NAME")
    private String name;

    public Region(){
    }

    public Region(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("ID= " + id + ", name= " + name);
    }

    @Override
    public String toString(){
        return "" + id + " " + name;
    }
}