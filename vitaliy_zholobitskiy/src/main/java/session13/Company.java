package session13;

import java.security.SecureRandom;

/**
 * Created by just1ce on 29.06.2015.
 */
public class Company {
    private int cash;
    private String name;
    private Car car;
    private Director director;
    public Company(String s) {
    }

    public Company(String s, int i) {
    }

    public Company() {
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    public Company(String name,int cash,Director director){
        this.name=name;
        this.cash=cash;
        this.director=director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
    @Override
    public String toString(){
        return name+" "+cash+" "+car.toString()+" "+director;
    }
}
