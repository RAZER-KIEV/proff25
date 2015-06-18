package session10;

import javax.persistence.*;
import java.util.Scanner;

/**
 * Created by george on 15.06.15.
 */
@Entity
@Table(name = "REGIONS")
public class Region {

    @Id
    @Column(name = "REGION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "REGION_NAME")
    private String name;

    public Region() {
        name = "Antarktida";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

