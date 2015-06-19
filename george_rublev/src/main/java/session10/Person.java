package session10;

import javax.persistence.*;

/**
 * Created by george on 15.06.15.
 */

@Entity

@Table(name = "persons")

public class Person {
    @Id
    @Column(name = "person_id")

    private long id;
    private String name;

    public Person() {

    }
}
