package hw4.parallel;

import java.util.ArrayList;

/**
 * Created by jax on 05.06.15.
 */
public class MyArrayList<E> extends ArrayList {
    private ArrayList<E> list;
    private int from;
    private int to;

    public MyArrayList(){
        this.list = new ArrayList<>();
    }


    public int paralellIndexOf(E e){
            if(e==null){
                for(int i=0;i<size();i++){
                    if(get(i)==null)
                        return i;
                }
            }else{
                NewThread potok1 = new NewThread(list,e,0,(size()/2));
                NewThread potok2 = new NewThread(list,e,(size()/2),size());
                potok1.start();
                potok2.start();
            }
        return -1;
    }

}

