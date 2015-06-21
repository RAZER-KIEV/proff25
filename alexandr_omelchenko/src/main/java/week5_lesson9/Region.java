package week5_lesson9;

import javax.persistence.*;

@Entity
@Table(name="REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name="sequence", sequenceName="SEQ_REGIONS_ID", allocationSize=1, initialValue =5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="REGION_ID")
    private Long id;

    @Column(name = "REGION_NAME")
    private String name;

    public Region(){name="defoult";}
    public Region(String region){name=region;}

    @Override
    public String toString() {
        return "Regions{" +
                "name='" + name + '\'' +
                '}';}
    public Long getId() {
        return id;}
    public void setId(Long Id) {
        this.id = Id;}
    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}
}
