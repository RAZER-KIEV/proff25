package session14;

/**
 * Created by bosyi on 29.06.15.
 */
public class Car {
    private String number;
    private CEO ceo;

    public Car() {
    }

    public Car(String number) {
        this.number = number;
    }

    public Car(String number, CEO ceo) {
        this.number = number;
        this.ceo = ceo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CEO getCeo() {
        return ceo;
    }

    public void setCeo(CEO ceo) {
        this.ceo = ceo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", ceo=" + ceo +
                '}';
    }
}
