package hw7.notes.domain;



/**
 * Created by Віктор on 7/11/2015.
 */
public class Store {
    private Long number;
    private Float price;
    private Notebook notebook;

    public Store(){}

    public Store(Long number, Float price, Notebook notebook){
        this.number = number;
        this.price = price;
        this.notebook = notebook;
    }
    public Long getNumber(){
        return number;
    }
    public Float getPrice(){
        return price;
    }
    public Notebook getNotebook(){
        return notebook;
    }
    public void setNumber(Long number){
        this.number = number;
    }
    public void setPrice(Float price){
        this.price = price;
    }
    public void setNotebook(Notebook notebook){
        this.notebook = notebook;
    }
    public void print(){
        System.out.print(number+" "+price+" "+notebook);

    }

}
