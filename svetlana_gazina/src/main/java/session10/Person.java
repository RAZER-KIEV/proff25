package session10;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sveta on 6/15/2015.
 */
@Entity
@Table (name = "persons")
public class Person {
    @Id
    @Column ()
    private long id;
    private String name;
}
