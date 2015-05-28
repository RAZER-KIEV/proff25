package session2.laboratory;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by oleg on 20.05.15.
 */
public class Main {
    public static void main(String[] args) {
//        ArrayList<Double> linked = new ArrayList<>();
        LinkedList<Double> linked = new LinkedList<>();

        for (int i = 0; i < 1000_0; i++){ /*616, 841, 766, 825*/
            linked.add(Math.random() * 10); /*114, 108, 124, 108 */
        }
//      for (int i = 0; i < 1000_000; i++){
//            linked.add(0, Math.random() * 10); /*1785, 1980, 1641*/
//      }                                         /*323132, 313862  */
        long first = System.currentTimeMillis();



//        for (int i = 0; i < 10000; i++){
//            linked.add(5000, Math.random() * 10); /*153(*100), 120(*100), 155(*100)*/
//        }                                          /*43(*100), 41, 36, 33*/
//
//      for (int i = 0; i < 1000_000; i++) {/*21, 20, 36, 21*/
//          linked.remove(linked.size() - 1); /*18, 11, 15*/
//      }


//      for (int i = 0; i < linked.size(); i++) {/*434(*100), 380(*100), 403(*100), 402(*100)*/
//          linked.indexOf(68.58);                /*425(*100), 410, 300, 378 */
//      }


        for (int i = 0; i < linked.size(); i++) {/*148(*100), 135(*100), 110(*100), 131(*100)*/
            linked.get(5000);                   /*1(*100), 3, 5, 4 */
        }

//        for (int i = 0; i < 1000_000; i++) {/*57, 29, 24, 21*/
//            linked.remove(0);               /* 322502, 323962, 268568*/
//        }

        long last = System.currentTimeMillis();
        System.out.println(last-first);
    }
}

class ListsCompareTest{

}