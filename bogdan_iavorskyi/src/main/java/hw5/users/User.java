package hw5.users;

import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;


/*
 * qqq
 */
public class User {

    private String login;
    private String hash;
    private Date creationDate;

    public User(String login, String password) {
        creationDate = new Date(System.currentTimeMillis());
        setLogin(login);
        setHash(password);
    }

    private User(String login, String hash, Date creationDate) {
        this.login = login;
        this.hash = hash;
        this.creationDate = creationDate;
    }

    static User returnUser(String login, String hash, Date creationDate) {
        return new User(login, hash, creationDate);
    }

    private void setLogin(String login) {
        if (login == null)
            throw new IllegalArgumentException("login cant be null");
        if (login.length() < 1 || login.length() > 20)
            throw new IllegalArgumentException("bad login length: " + login.length());
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    private void setHash(String password) {
        if (password == null)
            throw new IllegalArgumentException("password cant be null");
        if (password.length() < 5)
            throw new IllegalArgumentException("bad password length: " + password.length());
        hash = calculateHash(password);
    }

    public String getHash() {
        return hash;
    }

    String calculateHash(String password) {
        String hash = "";
        try {
            String valueForHash = login + password + login.charAt(0);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] bytes = messageDigest.digest(valueForHash.getBytes());
            hash = new String(Hex.encode(bytes));
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\n' +
                ", hash='" + hash + '\n' +
                ", creationDate=" + creationDate +
                '}';
    }
}
