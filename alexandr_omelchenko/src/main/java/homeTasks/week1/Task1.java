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
//���������� � ������
     long asADDF=System.nanoTime();//������
arList.add(0, -1);

     long afADDF=System.nanoTime();//�����
System.out.println("addFirst array time= " + (afADDF - asADDF));

      long lsADDF=System.nanoTime();//������
        linkList.addFirst(-1);
      long lfADDF=System.nanoTime();//�����
System.out.println("addFirst linked time= "+(lfADDF-lsADDF));

//���������� � �������
        long asADDM=System.nanoTime();//������
       arList.add(arList.size(),-1);
        long afADDM=System.nanoTime();//�����
System.out.println("addMiddle array time= " + (afADDM - asADDM) * 100);

        long lsADDM=System.nanoTime();//������
linkList.add(linkList.size(), -1);
        long lfADDM=System.nanoTime();//�����
System.out.println("addMiddle linked time= "+(lfADDM-lsADDM)*100);

//���������� � �����
      long asADDL=System.nanoTime();//������
      arList.add(-1);
      long afADDL=System.nanoTime();//�����
System.out.println("addLast array time= "+(afADDL-asADDL)*100);

        long lsADDL=System.nanoTime();//������
        linkList.add(-1);
        long lfADDL=System.nanoTime();//�����
System.out.println("addLast linked time= "+(lfADDL-lsADDL)*100);

//��������� �������� �� �������
        long asGETind=System.nanoTime();//������
        arList.get(500000);
        long afGETind=System.nanoTime();//�����
        System.out.println("GETind array time= "+(afGETind-asGETind)*100);

        long lsGETind=System.nanoTime();//������
        linkList.get(500000);
        long lfGETind=System.nanoTime();//�����
        System.out.println("GETind linked time= "+(lfGETind-lsGETind)*100);
//�������� �������� �� ������
        long asDELF=System.nanoTime();//������
        arList.remove(0);
        long afDELF=System.nanoTime();//�����
        System.out.println("DELFirst array time= "+(afDELF-asDELF)*100);

        long lsDELF=System.nanoTime();//������
        linkList.remove(0);
        long lfDELF=System.nanoTime();//�����
        System.out.println("DELFirst linked time= "+(lfDELF-lsDELF)*100);
//����� �� ��������
        long asFind=System.nanoTime();//������
        arList.contains(500000);
        long afFind=System.nanoTime();//�����
        System.out.println("FindByValue array time= " + (afFind - asFind) * 100);

        long lsFind=System.nanoTime();//������
        linkList.contains(500000);
        long lfFind=System.nanoTime();//�����
        System.out.println("FindByValue linked time= "+(lfFind-lsFind)*100);
    }
}