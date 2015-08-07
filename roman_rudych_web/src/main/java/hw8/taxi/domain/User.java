package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Роман on 11.07.2015.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "USER_SPEC_ID")
    private String specId;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_PASS")
    private String password;

    @Column(name = "USER_BLOCKED")
    private boolean blocked;

    @Column(name = "USER_PASS_SET_DATE")
    private Date passSetDate;

    @Column(name = "USER_PASS_EXPIRED_TIME")
    private Long expiredTimeMillis;

    public User() {
    }

    public User(String specId, String name, String password) {
        this.specId = specId;
        this.name = name;
        this.password = password;
        this.blocked = false;
        this.passSetDate = new Date(System.currentTimeMillis());
        this.expiredTimeMillis = 2629800000L; //1 month in millis
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

    public long getId() {
        return id;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Date getPassSetDate() {
        return passSetDate;
    }

    public void setPassSetDate(Date passSetDate) {
        this.passSetDate = passSetDate;
    }

    public Long getExpiredTimeMillis() {
        return expiredTimeMillis;
    }

    public void setExpiredTimeMillis(Long expiredTimeMillis) {
        this.expiredTimeMillis = expiredTimeMillis;
    }

    public String toString() {
        return "name: " + name + "; pass: " + password + ";";
    }

    public boolean equals(User user) {
        return name.equalsIgnoreCase(user.getName()) && password.equals(user.getPassword());
    }
}
