package taxi;

import taxi.domain.Client;
import taxi.domain.Operator;
import taxi.domain.Order;
import taxi.domain.TaxiDriver;

import java.time.LocalDateTime;

/**
 * Created by oleg on 27.07.15.
 */
public class Main {
    public static void main(String[] args) {
        Client cl = new Client("client", "bb", "cc", "dd");
        Operator oper = new Operator("oper", "111", 23343L);
        TaxiDriver tax = new TaxiDriver("taxist", "aa", "bb", "cc");
        Order order = new Order(cl, oper, tax, null, 2332L, "point a", "point b");
        System.out.println(order);
    }
}
