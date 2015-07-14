package scrum.domain;

import javax.persistence.*;

/**
 * Created by Inna on 14.07.2015.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USER_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "USER_LOGIN")
    private String userLogin;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User(String userPassword) {
        this.userPassword = userPassword;
    }
}
