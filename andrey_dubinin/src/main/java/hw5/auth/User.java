package hw5.auth;

/**
 * Created by jax on 13.06.15.
 */
public class User {
    private String name;
    private int id;
    private String password;
    private String date;

    public User(String name, int id,String password,String date){
        this.name = name;
        this.id =id;
        this.password = password;
        this.date = date;
    }


    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

