package hw7.notes.domain;

import java.util.Date;

/**
 * Created by Віктор on 7/12/2015.
 */
public class Sales {
    private Store store;
    private Date date;
    private Long number;

    public Sales(){

    }

    public Sales(Store store, Date date, Long number){
        this.store = store;
        this.date = date;
        this.number = number;
    }
    public Store getStore(){
        return store;
    }
    public Date getDate(){
        return date;
    }
    public Long getNumber(){
        return number;
    }
    public void setStore(Store store){
        this.store = store;
    }
    public void setDate (Date date){
        this.date = date;
    }
    public void setNumber(Long number){
        this.number = number;
    }
    public void print(){
        System.out.print(date +" "+ number);
    }
}
