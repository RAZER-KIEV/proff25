package session13;

/**
 * Created by just1ce on 29.06.2015.
 */
public class Car {
    private String model;
    private Director director;

    public Car(String s) {
        model=s;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    public Car(String model,Director director){
        this.model=model;
        this.director=director;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString(){
        return model;
    }
}
