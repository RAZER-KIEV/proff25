package session1;

/**
 * Created by bosyi on 18.05.15.
 */
public class Currency {

    private String name;
    private double rate;
    private int amountInDay;
    private boolean isAvailable;

    public Currency (String name, double rate, int amountInDay, boolean isAvailable) {
        this.name = name;
        this.rate = rate;
        this.amountInDay = amountInDay;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public int getAmountInDay() {
        return amountInDay;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Currency cur = (Currency) obj;
        if (name != null
                && name.equals(cur.getName())
                && rate == cur.getRate()
                && amountInDay == cur.getAmountInDay()
                && isAvailable == cur.getIsAvailable()) {
            return true;
        }
        return false;
    }

}
