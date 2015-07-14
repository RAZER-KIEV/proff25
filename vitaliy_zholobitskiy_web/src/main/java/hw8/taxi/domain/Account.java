package hw8.taxi.domain;


import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ACC_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ACC_ID")
    private Long id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String pass;
    @Column(name = "DATE_REG")
    private Date date;



    public Account() {
    }

    public Account(String login, String pass, Date date) {
        this.login=login;
        this.pass=pass;
        this.date=date;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", date=" + date +
                '}';
    }
}


