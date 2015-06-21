package session10;


import javax.persistence.*;

/**
 * Created by just1ce on 15.06.2015.
 */

@Entity
@Table(name = "REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 5, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")
    private Long id;
    @Column(name = "REGION_NAME")
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
}