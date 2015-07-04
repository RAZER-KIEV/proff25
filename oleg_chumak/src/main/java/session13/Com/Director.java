package session13.Com;

/**
 * Created by oleg on 29.06.15.
 */
public class Director {
    private String name;
    private Auto auto;

    public Director(String name, Auto auto) {
        this.name = name;
        this.auto = auto;
    }

    public Director() {
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", auto=" + auto +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
}
