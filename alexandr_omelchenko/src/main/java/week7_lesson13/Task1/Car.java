package week7_lesson13.Task1;

public class Car {

    private Director dir;

    public Car() {
    }
    public Car(Director dir) {
        this.dir = dir;
    }

    public Director getDir() {
        return dir;
    }
    public void setDir(Director dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "Car{" +
                "dir=" + dir +
                '}';
    }
}
