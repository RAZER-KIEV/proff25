package session10;

import javax.persistence.*;

/**
 * Created by george on 16.06.15.
 */
@Entity
@Table(name = "USERS")
public class Client {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME_USER")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "REG_DATE")
    private String regDate;

    public Client() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Client(String name, String password, String regDate) {
        this.name = name;
        this.password = password;
        this.regDate = regDate;
    }
}
