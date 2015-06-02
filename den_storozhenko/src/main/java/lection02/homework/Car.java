package lection02.homework;

import java.util.Random;

/**
 * Created by Lapchenko on 02.06.2015.
 */
public class Car{
    int number;

    public  Car(){
        number = new Random().nextInt();
    }

    public  Car(int n){
        number =n;
    }
}
