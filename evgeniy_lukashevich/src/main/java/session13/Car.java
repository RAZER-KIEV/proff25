package session13;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class Car {

    private Director director;

    private Car() {

    }

    public Car (Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Car: " + director;
    }

    public void setDirector (Director director) {
        this.director = director;
    }

    public Director getDirector () {
        return this.director;
    }
}
