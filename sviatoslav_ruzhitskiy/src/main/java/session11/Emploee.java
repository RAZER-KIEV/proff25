package session11;

import javax.persistence.*;

/**
 * Created by RAZER on 22.06.2015.
 */
@Entity
@Table(name = "EMPLOEES" )

public class Emploee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_EMPLOEYE_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    //@Column(name = "ID")
    private Long id;

    //@Column(name ="Empl_Name")
    private String name;

    @ManyToOne
    //@Column(name = "Company")
    private Company company;

    public Emploee(){}
    public Emploee(String name, Company company){
        this.name = name;
        this.company= company;
    }
    public String getName(){return name;}

}
