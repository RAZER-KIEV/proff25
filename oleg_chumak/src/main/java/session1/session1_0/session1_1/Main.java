package session1.session1_0.session1_1;

/**
 * Created by oleg on 18.05.15.
 */
public class Main {
    public static void main(String[] args) {
        Currency EUR = new Currency("Euro", 23.35, 10000, false);
        Currency USD = new Currency("Dollar", 20.67, 12000, true);
        Currency EURO = new Currency("Euro", 23.35, 10000, false);
        System.out.println(EUR.equals(USD));
        System.out.println(EUR.equals(EURO));
        System.out.println(EURO.equals(USD));
        System.out.println(EURO.equals(EUR));
    }
}
class Currency {
    private String name;
    private double rate;
    private int legalAmount;
    private boolean availability;

    public Currency(String name, double rate, int legalAmount, boolean availability){
        this.name = name;
        this.rate = rate;
        this. legalAmount = legalAmount;
        this.availability = availability;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) {
            return false;
        }
        if(object.getClass() != getClass()){
            return false;
        }
        if(object == this) {
            return true;
        }
        Currency obj = (Currency) object;
        return (name != null &&
                name == obj.name &&
                rate == obj.rate &&
                legalAmount == obj.legalAmount &&
                availability == obj.availability);
    }
}
