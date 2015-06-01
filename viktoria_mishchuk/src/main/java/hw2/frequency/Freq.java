package hw2.frequency;

import scala.Int;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Написать класс для вычисления частоты слов в тексте с методами:
 * - String setTextFromConsole()
 * - String setTextFromFile(String fileName)
 * - String generateRandomText(int textLength)
 * - Set<String> getWordsByFrequency(int frequency)
 * - Set<String> getWordsByFrequencyLessThan(int frequency)
 * - Set<String> getWordsByFrequencyMoreThan(int frequency)
 * - void printAcs() - вывести все слова + частота по возрастанию частоты
 * - void printDesc() - вывести все слова + частота по убыванию частоты
 * <p>
 * Класс задания hw2.frequency.Freq
 */
public class Freq {
    private Map<String, Integer> freq = new TreeMap<>();


    public String SetTextFromConsole(){
        Scanner scan = new Scanner(System.in);
        String fromConsole = scan.next();
        return fromConsole;
    }

    public String setTextFromFile(String fileName) throws FileNotFoundException {
        FileReader fr = new FileReader (fileName);
        Scanner scan = new Scanner(fr);
        StringBuffer sb = new StringBuffer();
        while (scan.hasNextLine()){
            sb.append(scan.nextLine() + " ");
        }
        return sb.toString();
    }

    public String generateRandomText( int textLength){
        Random rnd = new Random();
        Character[] chars = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y' ,'z',' '} ;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < textLength; i++) {
            sb.append(chars[new Random().nextInt(27)]);
        }
         return sb.toString();
    }

    public Set<String> getWordsByFrequency(int frequency){
        Set<String> tmp = new TreeSet<>();
        for (Map.Entry<String , Integer> val : freq.entrySet()){
            if(val.getValue() == frequency){
                tmp.add(val.getKey());
            }
        }
        return tmp;
    }

    public  Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> tmp = new TreeSet<>();
        for (Map.Entry<String, Integer> val : freq.entrySet()){
            if (val.getValue() <= frequency){
                tmp.add(val.getKey());
            }
        }
        return tmp;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency){
        Set<String> tmp = new TreeSet<>();
        for (Map.Entry<String, Integer> val : freq.entrySet()){
            if (val.getValue() >= frequency){
                tmp.add(val.getKey());
            }
        }
        return tmp;
    }

    public void printAcs(){





    }

    public  void printDesc(){

    }


}
