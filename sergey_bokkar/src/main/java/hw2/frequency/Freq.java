package hw2.frequency;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Well on 31.05.2015.
 *
 * Написать класс для вычисления частоты слов в тексте с методами:
 - String generateRandomText(int textLength)
 - Set<String> getWordsByFrequency(int frequency)
 - Set<String> getWordsByFrequencyLessThan(int frequency)
 - Set<String> getWordsByFrequencyMoreThan(int frequency)
 - void printAcs() - вывести все слова + частота по возрастанию частоты
 - void printDesc() - вывести все слова + частота по убыванию частоты.
 */
public class Freq {

    private Map<String, Integer> words = new HashMap<>();


    public String setTextFromConsole(){
        Scanner scan = new Scanner (System.in);
        String str = scan.nextLine();
        System.out.println(str);
        addStrToMap(str);
        return str;
    }

    public String setTextFromFile(String fileName) throws FileNotFoundException {
        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner (fr);
        StringBuilder sb = new StringBuilder();
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine() + " ");
        }
        String strfr = sb.toString();
        System.out.println(strfr);
        addStrToMap(strfr);
        return strfr;
    }

    public String generateRandomText(int textLength){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < textLength; i++){
            sb.append((char)(((int)(Math.random()*500)) + 29));
        }

        String strRand = sb.toString();
        System.out.println(strRand);
        addStrToMap(strRand);
        return strRand;
    }

    private void addStrToMap (String str) {
        String[] arr = str.split("\\s");
        for (int i = 0; i < arr.length; i++) {
            for (Map.Entry<String, Integer> w : words.entrySet()) {
                if (arr[i].contains(w.getKey())) {
                    Integer val = w.getValue();
                    val++;
                    words.put(arr[i], val);
                } else {
                    words.put(arr[i], 1);
                }
            }
        }
    }

    public Set<String> getWordsByFrequency(int frequency){
        Set<String> gwbf = new HashSet<>();
        for (Map.Entry<String, Integer> w : words.entrySet()){
            if (w.getValue() == frequency){
                gwbf.add(w.getKey());
            }
        }
        return gwbf;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency){
        Set<String> gwbflt = new HashSet<>();
        for (Map.Entry<String, Integer> w : words.entrySet()){
            if (w.getValue() < frequency){
                gwbflt.add(w.getKey());
            }
        }
        return gwbflt;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<String> gwbfmt = new HashSet<>();
        for (Map.Entry<String, Integer> w : words.entrySet()){
            if (w.getValue() > frequency){
                gwbfmt.add(w.getKey());
            }
        }
        return gwbfmt;
    }

    private void sort (ArrayList <Integer> sort) {
        for (Map.Entry<String, Integer> w : words.entrySet()) {
            sort.add(w.getValue());
        }
        Collections.sort(sort,
                new Comparator<Integer>() {
                    public int compare(Integer o1, Integer o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }
        );
    }

    public void printAcs(){
        ArrayList<Integer> arr = new ArrayList<>();
        sort(arr);
        StringBuilder sb = new StringBuilder();
       for (int i = 0; i < arr.size(); i++){
           for (Map.Entry<String, Integer> w : words.entrySet()) {
               if (arr.get(i) == w.getValue()) {
                   sb.append(w.getKey() + " ");
               }
           }
           System.out.println(sb.toString());
       }
    }

    public void printDesc(){
        ArrayList<Integer> arr = new ArrayList<>();
        sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = arr.size() - 1; i >= 0; i--){
            for (Map.Entry<String, Integer> w : words.entrySet()) {
                if (arr.get(i) == w.getValue()) {
                    sb.append(w.getKey() + " ");
                }
            }
        }
        System.out.println(sb.toString());
    }

}
