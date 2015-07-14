package scrum.domain;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Created by GFalcon on 14.07.15.
 */
@Entity
public class User {
    private Long id;
    private String login;
    private String pass;

    public User(){
// construct
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
