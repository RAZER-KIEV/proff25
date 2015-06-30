package session13;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class Director {

    private String name;

    public Director () {
    }

    public Director (String name) {
        this.name = name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    @Override
    public String toString() {
        return "Director: " + name;
    }
}
