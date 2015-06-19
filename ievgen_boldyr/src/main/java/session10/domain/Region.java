package session10.domain;

import javax.persistence.*;

/**
 * Created by IEvgen Boldyr on 15.06.15.
 * Project: proff25
 */

@Entity
@Table(name = "REGIONS")
public class Region {

    @Id
    @SequenceGenerator(name="sequance",  sequenceName = "region_id", allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequance")
    @Column(name = "REGION_ID")
    private Long id;

    @Column(name = "REGION_NAME")
    private String name;

    public Region() {}

    public Region(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
