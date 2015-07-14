package scrum.domain;

import javax.persistence.*;
import org.springframework.stereotype.*;
/**
 * Created by Inna on 14.07.2015.
 */
@Component
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USER_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String userPassword) {
        this.userPassword = userPassword;
    }
}
