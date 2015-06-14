package homework3;

import homework1.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jax on 05.06.15.
 */
public class MyArrayList<E> extends ArrayList{
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

            }
        return -1;
    }

}
class NewThread<E> implements Runnable{
    private int from;
    private int to;
    private E find;
    MyArrayList list = new MyArrayList();
    NewThread(E findElement, int from,int to){
        this.from=from;
        this.to=to;
        this.find=findElement;

    }

    @Override
    public void run() {
        for(int i=from;i<=to;i++){
            if(list.get(i)==find){
                return ;
            }
        }
    }
}