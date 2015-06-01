package session1;

/**
 * Created by bosyi on 18.05.15.
 */
public class CurrencyMain {
    public static void main(String[] args) {
        Currency cur1 = new Currency("usd",0.05,200,false);
        Currency cur2 = new Currency("usd",0.05,200,false);
        Currency cur3 = new Currency("eur",0.04,150,false);
        System.out.println(cur1.equals(cur2)?"equals":"not equals");
        System.out.println(cur1.equals(cur3)?"equals":"not equals");
    }
}
