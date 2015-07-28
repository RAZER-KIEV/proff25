package hw8.taxi;

import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
        System.out.println(IsValid.isValidPhone("+389999999999"));
    }
}
