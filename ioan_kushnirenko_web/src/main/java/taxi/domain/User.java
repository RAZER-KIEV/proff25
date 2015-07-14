package taxi.domain;

import javax.persistence.*;

/**
 * Created by viktoria
 * Project:.hw8.taxi.domain
 */

@Entity
@Table (name = "USER")
public class User {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_USER_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column (name = "ID")
    private Long id;

    @Column (name = "LOGIN")
    private String login;

    @Column (name = "PASSWORD")
    private String password;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
