package session10;

import javax.persistence.*;

/**
 * Created by Sveta on 6/15/2015.
 */
@Entity
@Table (name = "REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
                              allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")
    private long id;

    @Column(name = "REGION_NAME")
    private String name;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
