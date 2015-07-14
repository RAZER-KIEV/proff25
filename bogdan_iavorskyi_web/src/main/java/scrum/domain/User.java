package scrum.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by GFalcon on 14.07.15.
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASS")
    private String pass;

    public User(){

    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPass(), user.getPass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPass());
    }
}
