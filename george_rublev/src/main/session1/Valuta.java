package main.session1;

/**
 * Created by george on 18.05.15.
 */
class ValutaO {

    String name;
    int curs;
    int maxInD;
    boolean nalValut;


    @Override
    public boolean equals(Object obj){

        if (obj instanceof ValutaO){

                if (curs == (Integer) obj) {
                    if (maxInD == (Integer) obj) {
                        if (nalValut) {
                            return true;
                        }
                    }
                }

        }


        return false;
    }



}

public class Valuta{
    public static void main(String[] args) {

    }
}
