package lection01;

/**
 * Created by storo_000 on 18.05.2015.
 */
public class Valuta extends Object{
    String name;
    int kurs;
    int count_for_day;
    boolean isAvaible;

    Valuta(){
        name="";
        kurs=0;
        count_for_day=0;
        isAvaible=false;
    }

    Valuta(String n, int k, int c, boolean isAv){
        name=n;
        kurs=k;
        count_for_day=c;
        isAvaible=isAv;
    }

    String getName(){
        return name;
    }

    public int getKurs(){
        return kurs;
    }

    public int getCount_for_day(){
        return count_for_day;
    }

    public boolean getIsAvaible(){
        return isAvaible;
    }
    @Override
    public boolean equals(Object valuta){
        if (this==valuta){
            return true;
        }
        if (valuta==null){
            return false;
        }
        if (!(valuta.getClass()==getClass()))
            return false;
        Valuta val=(Valuta)valuta;
        boolean f=name.equals(val.getName());
        if (    name!=null &&
                name.equals(val.name)&&
                kurs==val.kurs &&
                count_for_day==val.count_for_day &&
                isAvaible==val.isAvaible
                )
        return true;
        return false;
    }

    public static void main(String[] args) {
        Valuta valuta1=new Valuta("Valuta1", 15, 30, false);
        Valuta valuta2=new Valuta("Valuta2", 30, 50, true);
        Valuta valuta3=new Valuta("Valuta1", 15, 30, false);
        Valuta valuta4=new Valuta("Valuta2", 30, 50, true);
        System.out.println(valuta1.equals(valuta2));
        System.out.println(valuta1.equals(valuta3));
        System.out.println(valuta1.equals(valuta4));
        System.out.println(valuta2.equals(valuta3));
        System.out.println(valuta2.equals(valuta4));
        System.out.println(valuta3.equals(valuta4));
    }
}
//Создать класс валюта со сл пар-ми:
//  название,
//  курс к грн,
//  кол-во едениц, выдаваемых на руки в день,
//  наличие(False),
//  переопределить equals, проверить работоспособность