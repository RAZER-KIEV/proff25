package hw4.parallel;

/**
 * Created by RAZER on 03.06.2015.
 *
 */
import java.util.Iterator;


    public class MyArrayList<E> implements Iterable{
        E [] mainmass;
        private E[] mainmassForClone;
        private int capacity = 0;
        int cursize=0;
        public static int index =-1;
        public MyArrayList(){
            mainmass = (E[]) new Object[capacity];
        }

        public void incrArray(){
            mainmassForClone = mainmass.clone();
            capacity++;
            mainmass= (E[]) new Object[capacity];
            for(int j=0; j<mainmassForClone.length;j++){
                mainmass[j]=mainmassForClone[j];

            }
        }

        public void add(E value){
            this.add(mainmass.length,value);
        }


        public E get(int index){
            if(index<mainmass.length){
                return mainmass[index];}

            return (E) null;
        }
        public boolean set(int index, E value){
            try{
                mainmass[index] = value;
                return true;
            }
            catch (Exception e){
                System.out.println("set Error"+e);
                return  false;
            }
        }
        public boolean add(int index, E value){
            if(index<mainmass.length){
                mainmass[index] = value;
                return true;
            }
            else {
                incrArray();
                this.add(index, value);

            }
            return true;
        }
        public int indexOf(E value){
            for(int i=0; i<mainmass.length;i++){
                if(mainmass[i]!=null){
                    if(mainmass[i].equals(value)){
                        return i;

                    }
                }
            }

            return -1;
        }
        public int parallelIndexOf(E e){
            ThreadGroup group = new ThreadGroup("SearchGroup");
            int _25 =(int) (mainmass.length*0.25);
            int _50 =(int) (mainmass.length*0.5);
            int _75 = (int) ( mainmass.length*0.75);
             // ThreadsMaker threadsMaker = new ThreadsMaker()
            new Thread(group, new ThreadsMaker(0,_25,mainmass,e));
            new Thread(group, new ThreadsMaker(_25,_50,mainmass,e));
            new Thread(group, new ThreadsMaker(_50,_75,mainmass,e));
            new Thread(group, new ThreadsMaker(_75,mainmass.length,mainmass,e));
            return index;
            }

        public int size(){
            return mainmass.length;

        }
        public E remove(int index){
            if(mainmass[index]!= null){
                E value = mainmass[index];
                for(int i = index; i<mainmass.length-1;i++) {
                    mainmass[i] = mainmass[i+1];
                }
                mainmassForClone = mainmass.clone();
                cursize= mainmass.length-1;
                mainmass= (E[]) new Object[cursize];
                for(int j=0; j<mainmassForClone.length-1;j++){
                    mainmass[j]=mainmassForClone[j];

                }

                return value;}
            return null;
        }



        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                int cursor=0;

                @Override
                public boolean hasNext() {
                    if(mainmass.length>cursor)return true;
                    else  return false;
                }

                @Override
                public E next() {
                    return mainmass[cursor+1];
                }
            };
        }
    }
    class MyArrayListTest{
        public static void main(String[] args) {
            MyArrayList<Integer> MALTest = new MyArrayList<>();
           System.out.println("0 " + MALTest.size());
            MALTest.add(200);
            System.out.println("get: 200 " + MALTest.get(0));
            System.out.println("0 " + MALTest.indexOf(200));
            System.out.println("1 " + MALTest.size());
            MALTest.add(40, 400);
            System.out.println(MALTest.size());
            MALTest.add(105, 1050);
            System.out.println("1050 " + MALTest.get(105));
            MALTest.add(200);
            System.out.println("Wait for 107 " + MALTest.size());
            System.out.println("200 "+MALTest.get(0));
            int index = MALTest.indexOf(1050);
            System.out.println("105 "+index);
            MALTest.get(5000);
            MALTest.remove(0);
            MALTest.parallelIndexOf(1050);


        }
    }
class ThreadsMaker extends Thread{
    MyArrayList arrlist = new MyArrayList<>();
    Object [] mass;
    int bigin;
    int end;
    Object value;
    ThreadsMaker thred;
    int index;
   // ThreadGroup group;
    static Thread thread;
    public ThreadsMaker(int bigin,int end, Object [] mass , Object value){
        this.bigin = bigin;
        this.end = end;
        this.mass = mass;
        this.value = value;
        //this.group = group;
        this.start();


    }

     public void run() throws NullPointerException{
         thred = (ThreadsMaker) Thread.currentThread();
        do {
             for (int i = bigin; i <= end; i++){
                       if (mass[i] != null) {
                         if (mass[i].equals(value)) {
                             index = i;
                            // pushI(index);
                             System.out.println("индекс найден потоком: " + thred.getName() + " index: " + i);
                             getThreadGroup().interrupt();

                         }
                     }
                 }
         } while(thread.isInterrupted());

    }
    public void pushI(int index){
        MyArrayList.index = index;
        System.out.println("index pushed!" +index);


    }
}



