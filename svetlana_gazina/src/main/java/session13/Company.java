package session13;

/**
 * Created by Sveta on 6/29/2015.
 */
public class Company {
    private String name;
    private int money;
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String toString() {
        return "Name: " + getName() + "; Money: " + getMoney() + "      " + "Car: " + getCar();
    }
}
