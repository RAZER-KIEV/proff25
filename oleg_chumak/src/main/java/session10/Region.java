package session10;

import javax.persistence.*;

/**
 * Created by oleg on 15.06.15.
 */

@Entity
@Table(name="REGIONS")
public class Region {
    public Region(String name) {
        this.name = name;
    }

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID", allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column(name="REGION_ID")

    private int id;

    @Column(name = "REGION_NAME")
    private String name;

    public Region() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
