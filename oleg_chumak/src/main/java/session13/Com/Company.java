package session13.Com;

/**
 * Created by oleg on 29.06.15.
 */
public class Company {
    private String name;
    private Director director;
    private Auto auto;
    private int money;

    public Company(String name, Director director, Auto auto, int money) {
        this.name = name;
        this.director = director;
        this.auto = auto;
        this.money = money;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", auto=" + auto +
                ", money=" + money +
                '}';
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
