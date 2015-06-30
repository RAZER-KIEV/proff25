package week7_lesson13.Task1;

/**
 * Created by HP on 29.06.2015.
 */
public class Company {
    private String name;
    private Double money;
   private Director dir;
   private Car car;

    public Company() {
    }
    public Company(String name) {
        this.name = name;
    }
    public Company(Double money) {
        this.money = money;
    }
    public Company(Director dir) {
        this.dir = dir;
    }
    public Company(Car car) {
        this.car = car;
    }
    public Company(String name, Double money) {
        this.name = name;
        this.money = money;
    }
    public Company(String name, Double money, Director dir, Car car) {
        this.name = name;
        this.money = money;
        this.dir = dir;
        this.car = car;
    }
    public Company(String name, Double money, Director dir) {
        this.name = name;
        this.money = money;
        this.dir = dir;
    }
    public Company(String name, Double money, Car car) {
        this.name = name;
        this.money = money;
        this.car = car;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public Director getDir() {
        return dir;
    }
    public void setDir(Director dir) {
        this.dir = dir;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", dir=" + dir +
                ", car=" + car +
                '}';
    }
}
