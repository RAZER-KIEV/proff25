package scrum.domain;

import hw8.taxi.domain.Operator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by User on 14.07.2015.
 */
@Entity
@Table(name = "TAXI")
public class Taxi { @Id
@SequenceGenerator(name = "sequence", sequenceName = "SEQ_TAXI_ID", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
private Long id;

    @Column(name = "NAME_")
    private String name;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "MARKA")
    private String marka;

    @Column(name = "NUMBER_")
    private String number;
    public Taxi() {
    }

    public Taxi(String name, String telefon, String marka, String number) {
        this.name = name;
        this.telefon = telefon;
        this.marka = marka;
        this.number = number;

    }


    public Taxi(Long id, String name, String telefon, String marka, String number) {
        this.id = id;
        this.name = name;
        this.telefon = telefon;
        this.marka = marka;
        this.number = number;

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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
