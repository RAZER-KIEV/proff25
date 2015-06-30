package week7_lesson13.Task1;

/**
 * Created by HP on 29.06.2015.
 */
public class Director {
    private String name;
    public Director() {
    }

    public Director(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                '}';
    }
}
