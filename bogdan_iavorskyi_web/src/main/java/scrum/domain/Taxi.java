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
    private String surname;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

}
