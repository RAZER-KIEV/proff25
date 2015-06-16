package lection02.homework;

import java.util.Random;

public class Car{
    int number;

    public  Car(){
        number = new Random().nextInt();
    }

    public  Car(int n){
        number =n;
    }
}
