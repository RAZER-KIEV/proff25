package HT1;
import java.util.Iterator;

public class MyArrayList {
    public int length;
    public int [] list;
    public static int ite=0;

    public MyArrayList(){
        length=0;
        list=new int[0];}

    public MyArrayList(int l){
        length=l;
        list=new int[l];}

    public void add(int value){
        int [] templist=new int[length+1];
        for(int i=0; i<length;i++){
            templist [i]= list[i];}
        templist[length]=value;
        list=templist;
        length++;}

    public int get(int index){
        if (index>=length || index<0){return -1;}
        else return list[index];}

    public boolean set(int index, int value){
        if (index>=length || index<0) return false;
        else {list[index] = value; return true; }}

    public boolean add(int index, int value){
        if (index>length || index<0) return false;
        else {int [] templist = new int[length+1];
            for(int i=0; i<index;i++)     {templist[i]=list[i];}
            templist[index]=value;
            for(int i=index; i<length;i++){templist[i+1]=list[i];}
            list=templist;
            length++;
            return true; }}

    public int indexOf(int value){
        for (int i=0; i<length; i++)
            if (list[i]==value)
                return i;
        return -1;}

    public int size(){
        return length;
    }
    public int remove(int index){
        int rez=list[index];
        int [] templist = new int[length-1];
        if (index>=length || index<0) return -1;
        else{ for(int i=0; i<index;i++)        {templist[i]=list[i];}
            for(int i=index; i<length-1;i++) {templist[i]=list[i+1];}}
        list=templist;
        length--;
        return rez;
    }

  //  @Override
 //   public Iterator iterator() {
  //      return list.values().iterator();
  //      return null;
//    }
}