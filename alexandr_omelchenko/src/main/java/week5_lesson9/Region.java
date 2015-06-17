package week5_lesson9;

import javax.persistence.*;

@Entity
@Table(name="REGIONS")
public class Region {
    @Id
    @Column(name="REGION_ID")
    @SequenceGenerator(name="sequence", sequenceName="SEQ_REGIONS_ID", allocationSize=1, initialValue =5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    private Long REGION_ID;
    private String name;

    public Region(){
        name="defoult";
    }
    public Region(String region){
        name=region;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "name='" + name + '\'' +
                '}';
    }
    public Long getREGION_ID() {
        return REGION_ID;}
    public void setREGION_ID(Long REGION_ID) {
        this.REGION_ID = REGION_ID;}
    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}
}
