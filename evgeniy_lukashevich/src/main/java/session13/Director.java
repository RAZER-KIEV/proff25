package session13;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class Director {

    private String name;

    public Director (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }

}
