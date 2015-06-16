package session10;

import javax.persistence.*;

/*
 *
 */
@Entity
@Table(name="REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID", allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")

    private int id;

    @Column(name = "REGION_NAME")
    private String regionName;

    public Region() {
    }

    public Region(String regionName) {
        setRegionName(regionName);
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }
}
