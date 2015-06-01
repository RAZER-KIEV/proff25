package homeTasks.week1;
import java.util.ArrayList;
import java.util.LinkedList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer>arList= new ArrayList<>();
        LinkedList<Integer>linkList=new LinkedList<>();
        for(int i=0;i<1000000;i++){
            arList.add(i+1);
            linkList.add(i+1);   }
//Добавление в начало
     long asADDF=System.nanoTime();//Начало
arList.add(0, -1);

     long afADDF=System.nanoTime();//Конец
System.out.println("addFirst array time= " + (afADDF - asADDF));

      long lsADDF=System.nanoTime();//Начало
        linkList.addFirst(-1);
      long lfADDF=System.nanoTime();//Конец
System.out.println("addFirst linked time= "+(lfADDF-lsADDF));

//Добавление в средину
        long asADDM=System.nanoTime();//Начало
       arList.add(arList.size(),-1);
        long afADDM=System.nanoTime();//Конец
System.out.println("addMiddle array time= " + (afADDM - asADDM) * 100);

        long lsADDM=System.nanoTime();//Начало
linkList.add(linkList.size(), -1);
        long lfADDM=System.nanoTime();//Конец
System.out.println("addMiddle linked time= "+(lfADDM-lsADDM)*100);

//Добавление в конец
      long asADDL=System.nanoTime();//Начало
      arList.add(-1);
      long afADDL=System.nanoTime();//Конец
System.out.println("addLast array time= "+(afADDL-asADDL)*100);

        long lsADDL=System.nanoTime();//Начало
        linkList.add(-1);
        long lfADDL=System.nanoTime();//Конец
System.out.println("addLast linked time= "+(lfADDL-lsADDL)*100);

//Получение елемента по индексу
        long asGETind=System.nanoTime();//Начало
        arList.get(500000);
        long afGETind=System.nanoTime();//Конец
        System.out.println("GETind array time= "+(afGETind-asGETind)*100);

        long lsGETind=System.nanoTime();//Начало
        linkList.get(500000);
        long lfGETind=System.nanoTime();//Конец
        System.out.println("GETind linked time= "+(lfGETind-lsGETind)*100);
//Удаление елемента из начала
        long asDELF=System.nanoTime();//Начало
        arList.remove(0);
        long afDELF=System.nanoTime();//Конец
        System.out.println("DELFirst array time= "+(afDELF-asDELF)*100);

        long lsDELF=System.nanoTime();//Начало
        linkList.remove(0);
        long lfDELF=System.nanoTime();//Конец
        System.out.println("DELFirst linked time= "+(lfDELF-lsDELF)*100);
//Поиск по значению
        long asFind=System.nanoTime();//Начало
        arList.contains(500000);
        long afFind=System.nanoTime();//Конец
        System.out.println("FindByValue array time= " + (afFind - asFind) * 100);

        long lsFind=System.nanoTime();//Начало
        linkList.contains(500000);
        long lfFind=System.nanoTime();//Конец
        System.out.println("FindByValue linked time= "+(lfFind-lsFind)*100);
    }
}