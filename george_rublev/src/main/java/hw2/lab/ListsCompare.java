package hw2.lab;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by george on 22.05.15.
 */
public class ListsCompare {
    public static void main(String[] args) {

        new ListsCompareTest(10000);

    }


}

class ListsCompareTest{
    ArrayList<Integer> ali;
    LinkedList<Integer> lli;
    ListsCompareTest(){
            int elTo=10000;
            long startAliTest, endAliTest;
            //ArrayList
            ali = new ArrayList<Integer>();
            startAliTest = System.nanoTime();
            //add to start ArrayList
            for(int i= 0; i<elTo;i++){
                ali.add(0,i);
            }
            endAliTest = System.nanoTime();
            System.out.println("ArrayList to start :                 "+nanoToTime(endAliTest-startAliTest));
            ali = new ArrayList<Integer>();
            startAliTest = System.nanoTime();
            // add to end ArrayList
            for(int i =0;i<elTo;i++){
                ali.add(i);
            }
            endAliTest = System.nanoTime();
            System.out.println("ArrayList to end :                   "+nanoToTime(endAliTest-startAliTest));
//            System.out.println(ali);
            //add to centr ArrayList
            ali = new ArrayList<Integer>();
            startAliTest = System.nanoTime();
            ali.add(0);
            for(int i = 1; i<elTo;i++){
                ali.add(1,i);
            }
            endAliTest = System.nanoTime();
            System.out.println("ArrayList to centre :                " + nanoToTime(endAliTest - startAliTest));
            //get element by index
            startAliTest = System.nanoTime();
            ali.get(elTo/2);
            endAliTest = System.nanoTime();
            System.out.println("ArrayList get element by index :     " + nanoToTime(endAliTest-startAliTest));
            //finde element by value
            startAliTest = System.nanoTime();
            ali.contains(elTo/2);
            endAliTest = System.nanoTime();
//          System.out.println("ArrayList get element by index 500:  " + nanoToTime(endAliTest-startAliTest));
            System.out.println("ArrayList finde element by value :   " + nanoToTime(endAliTest-startAliTest));
            // delet element from start
            startAliTest=System.nanoTime();
            while (ali.size()>0){
                ali.remove(0);
            }
            endAliTest = System.nanoTime();
//          System.out.println("ArrayList get element by index 500:  " + nanoToTime(endAliTest-startAliTest));
            System.out.println("ArrayList remove from start :        " + nanoToTime(endAliTest-startAliTest));


            System.out.println("-------------------------------------------------------------------------------------");
            //LinkedList
            //add to start
            lli = new LinkedList<Integer>();
            startAliTest = System.nanoTime();
            //add to start ArrayList
            for(int i= 0; i<elTo;i++){
                lli.add(0,i);
            }
            endAliTest = System.nanoTime();
            System.out.println("LinkedList to start :                "+nanoToTime(endAliTest-startAliTest));
            lli = new LinkedList<Integer>();
            //add to end
            startAliTest = System.nanoTime();
            for(int i =0;i<elTo;i++){
                lli.add(i);
            }
            endAliTest = System.nanoTime();
            System.out.println("LinkedList to end :                  "+nanoToTime(endAliTest-startAliTest));
            //add to centre
            lli = new LinkedList<Integer>();
            startAliTest = System.nanoTime();
            lli.add(0,0);
            for(int i = 1;i<elTo;i++){
                lli.add(1,i);
            }
            endAliTest = System.nanoTime();
            System.out.println("LinkedList to centre :               " + nanoToTime(endAliTest - startAliTest));
            //get element by index
            startAliTest = System.nanoTime();
            lli.get(elTo/2);
            endAliTest = System.nanoTime();
            System.out.println("LinkedList get element by index :    " + nanoToTime(endAliTest-startAliTest));
            //find element by value
            startAliTest = System.nanoTime();
            lli.contains(elTo/2);
            endAliTest = System.nanoTime();
            System.out.println("LinkedList finde element by value :  " + nanoToTime(endAliTest-startAliTest));
            //remove from start
            startAliTest = System.nanoTime();
            while(lli.size()>0){
                lli.remove(0);
            }

            endAliTest= System.nanoTime();
            System.out.println("LinkedList remove from start :       " + nanoToTime(endAliTest-startAliTest));
        }
    ListsCompareTest(int maxElement){
        int elTo=maxElement;
        long startAliTest, endAliTest;
        //ArrayList
        ali = new ArrayList<Integer>();
        startAliTest = System.nanoTime();
        //add to start ArrayList
        for(int i= 0; i<elTo;i++){
            ali.add(0,i);
        }
        endAliTest = System.nanoTime();
        System.out.println("ArrayList to start :                 "+nanoToTime(endAliTest-startAliTest));
        ali = new ArrayList<Integer>();
        startAliTest = System.nanoTime();
        // add to end ArrayList
        for(int i =0;i<elTo;i++){
            ali.add(i);
        }
        endAliTest = System.nanoTime();
        System.out.println("ArrayList to end :                   "+nanoToTime(endAliTest-startAliTest));
//            System.out.println(ali);
        //add to centr ArrayList
        ali = new ArrayList<Integer>();
        startAliTest = System.nanoTime();
        ali.add(0);
        for(int i = 1; i<elTo;i++){
            ali.add(1,i);
        }
        endAliTest = System.nanoTime();
        System.out.println("ArrayList to centre :                " + nanoToTime(endAliTest - startAliTest));
        //get element by index
        startAliTest = System.nanoTime();
        ali.get(elTo/2);
        endAliTest = System.nanoTime();
        System.out.println("ArrayList get element by index :     " + nanoToTime(endAliTest-startAliTest));
        //finde element by value
        startAliTest = System.nanoTime();
        ali.contains(elTo/2);
        endAliTest = System.nanoTime();
//          System.out.println("ArrayList get element by index 500:  " + nanoToTime(endAliTest-startAliTest));
        System.out.println("ArrayList finde element by value :   " + nanoToTime(endAliTest-startAliTest));
        // delet element from start
        startAliTest=System.nanoTime();
        while (ali.size()>0){
            ali.remove(0);
        }
        endAliTest = System.nanoTime();
//          System.out.println("ArrayList get element by index 500:  " + nanoToTime(endAliTest-startAliTest));
        System.out.println("ArrayList remove from start :        " + nanoToTime(endAliTest-startAliTest));


        System.out.println("-------------------------------------------------------------------------------------");
        //LinkedList
        //add to start
        lli = new LinkedList<Integer>();
        startAliTest = System.nanoTime();
        //add to start ArrayList
        for(int i= 0; i<elTo;i++){
            lli.add(0,i);
        }
        endAliTest = System.nanoTime();
        System.out.println("LinkedList to start :                "+nanoToTime(endAliTest-startAliTest));
        lli = new LinkedList<Integer>();
        //add to end
        startAliTest = System.nanoTime();
        for(int i =0;i<elTo;i++){
            lli.add(i);
        }
        endAliTest = System.nanoTime();
        System.out.println("LinkedList to end :                  "+nanoToTime(endAliTest-startAliTest));
        //add to centre
        lli = new LinkedList<Integer>();
        startAliTest = System.nanoTime();
        lli.add(0,0);
        for(int i = 1;i<elTo;i++){
            lli.add(1,i);
        }
        endAliTest = System.nanoTime();
        System.out.println("LinkedList to centre :               " + nanoToTime(endAliTest - startAliTest));
        //get element by index
        startAliTest = System.nanoTime();
        lli.get(elTo/2);
        endAliTest = System.nanoTime();
        System.out.println("LinkedList get element by index :    " + nanoToTime(endAliTest-startAliTest));
        //find element by value
        startAliTest = System.nanoTime();
        lli.contains(elTo/2);
        endAliTest = System.nanoTime();
        System.out.println("LinkedList finde element by value :  " + nanoToTime(endAliTest-startAliTest));
        //remove from start
        startAliTest = System.nanoTime();
        while(lli.size()>0){
            lli.remove(0);
        }

        endAliTest= System.nanoTime();
        System.out.println("LinkedList remove from start :       " + nanoToTime(endAliTest-startAliTest));
    }


    private String nanoToTime(long nanotime){
        StringBuilder sb = new StringBuilder();
        long nano =0, mikro =0, mili = 0, sec  = 0;

        //sep nano sec
        if(nanotime>0) {
            nano = sep(nanotime);
            nanotime = nanotime / 1000;
        }
        if(nanotime>0){
            mikro = sep(nanotime);
            nanotime = nanotime/1000;
        }
        if(nanotime>0){
            mili = sep(nanotime);
            nanotime = nanotime/1000;
        }
        if(nanotime>0){
            sec = sep(nanotime);
            nanotime = nanotime/1000;
        }

        return sb.append(sec+" sec ").
                append(mili+ " mili sec ").
                append(mikro+" mikro sec ").
                append(nano+" nano sec").
                toString();
    }

    private long sep(long sepTime){
        long bufTime = sepTime;
        long buf = 0;
        if(sepTime > 0){
            buf = sepTime%1000;
//            bufTime = sepTime/1000;
        }
        return (buf);
    }
}
