package lection07;

/**
 * Created by storo_000 on 29.06.2015.
 */
public class Car {
    private Director director;

    public Car() {
    }

    public Car(Director director) {
        this.director = director;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Car{" +
                "director=" + director.toString() +
                '}';
    }
}
