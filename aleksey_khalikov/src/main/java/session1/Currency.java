package session1;

/**
 * Created by GFalcon on 18.05.15.
 */
public class Currency {
    private String name;
    private double rate;
    private int legalAmount;
    private boolean availability;

    Currency(String name, double rate, int legalAmount, boolean availability){
        this.name = name;
        this.rate = rate;
        this.legalAmount = legalAmount;
        this.availability = availability;
    }


    @Override
    public boolean equals(Object curr){

        if (curr.getClass() != getClass()){
            return false;
        }
        Currency obj = (Currency) curr;
        /*
        if(this.name.equals(obj.name)){
            if(this.curEx == obj.corEx){
                if(this.avay == obj.avay){
                    if(this.nal == obj.nal){
                        return true;
                    }
                }
            }
        }
        */
        return false;
    }
}
