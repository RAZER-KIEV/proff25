package session13;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class Company {

    private String name;
    private int account;
    private Director director;
    private Car car;

    public Company () {

    }

    public Company (String name) {
        this.name = name;
    }

    public Company (int account) {
        this.account = account;
    }

    public Company (String name, int account) {
        this.name = name;
        this.account = account;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setAccount (int account) {
        this.account = account;
    }

    public String getName () {
        return this.name;
    }

    public int getAccount () {
        return this.account;
    }

    public void setDirector (Director director) {
        this.director = director;
    }

    public void setCar (Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Name: " + name + " , Account: " + account +
                " " + director + " " + car;
    }
}
