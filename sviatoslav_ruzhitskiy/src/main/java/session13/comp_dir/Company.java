package session13.comp_dir;

import javax.swing.*;

/**
 * Created by RAZER on 29.06.2015.
 */
public class Company {
    private double money;
    private Spring name;

    public Company(){}

    public Company(Spring name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setName(Spring name) {
        this.name = name;
    }

    public double getMoney() {

        return money;
    }

    public Spring getName() {
        return name;
    }

    public Company(double money, Spring name) {

        this.money = money;
        this.name = name;
    }
    public String toString(){
        return "name: "+name+", money: "+money;
    }
}
