package comandWork.domain;

import javax.persistence.*;

/**
 * Created by RAZER on 14.07.2015.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_PASSWORD")
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
