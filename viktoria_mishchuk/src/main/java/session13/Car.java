package session13;

/**
 * Created by viktoria
 * Project:.session13
 */
public class Car {

    private String model;

    private Director director;

    public Car() {
    }

    public Car(String model, Director director) {
        this.model = model;
        this.director = director;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
