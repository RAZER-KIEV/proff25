package scrum.domain;

import javax.persistence.*;

/**
 * Created by User on 14.07.2015.
 */
@Entity
@Table(name = "TAXI")
public class Taxi { @Id
@SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "MARKA")
    private String marka;

    @Column(name = "NUMBER")
    private String number;

}
