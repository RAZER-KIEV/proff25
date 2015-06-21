package session10;

import javax.persistence.*;

/**
 * Created by Inna on 15.06.2015.
 */
@Table(name = "REGIONS")
@Entity
public class Region {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID", allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "REGION_ID")
    private Long id;

    @Column (name = "REGION_NAME")
    private String name;

    public Region() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
