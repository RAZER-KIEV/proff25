package session4.hw4;

import org.h2.mvstore.DataUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by oleg on 27.05.15.
 */
public class Freq {
    TreeMap<String, Integer> map = new TreeMap<>();

    public String generateRandomText(int textLength){
        StringBuilder sb = new StringBuilder();
        String dict = "zxcvbnm,./asdfghjkl;qwertyuiop[]1234567890-= ";
        for (int i = 0; i <textLength; i++) {
            char c = dict.charAt(((int) (Math.random() * 10) + (int) (Math.random() * 100) + (int) (Math.random() * 1000)) % dict.length());
            sb.append(c);
        }
            return sb.toString();

    }
    public String setTextFromConsole(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Set text from Console");
        Scanner scan = new Scanner(System.in);
        String tmp;
            tmp = scan.nextLine();
            sb.append(tmp);
        scan.close();
        return sb.toString();
    }

    public String setTextFromFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(FileReader fir = new FileReader(fileName)){
            int character;
            while((character = fir.read()) > 0){
                sb.append((char) character);
            }
        }
        return sb.toString();
    }

    public void textToMap(String str){
        String[] a = str.split("\\s");
        for (int i = 0; i < a.length; i++){
            wordToMap(a[i]);
        }
    }

    private void wordToMap(String word) {
        if (map.containsKey(word)) {
            int tmp = map.get(word);
            map.put(word, tmp + 1);
        } else map.put(word, 1);
    }

    public Set<String> getWordsByFrequency(int frequency) {
        Set<Map.Entry<String, Integer>> keys = map.entrySet();
        HashSet<String> tmp = new HashSet<>();
        for (Map.Entry ke : keys) {
            if (map.get(ke.getKey()) == frequency) {
                tmp.add((String) ke.getKey());
            }
        }
        return tmp;
    }


    public Set<String>  getWordsByFrequencyLessThan(int frequency){
        Set<Map.Entry<String, Integer>> keys = map.entrySet();
        HashSet<String> tmp = new HashSet<>();
        for (Map.Entry ke : keys) {
            if (map.get(ke.getKey()) < frequency) {
                tmp.add((String) ke.getKey());
            }
        }
        return tmp;

    }


    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<Map.Entry<String, Integer>> keys = map.entrySet();
        HashSet<String> tmp = new HashSet<>();
        for (Map.Entry ke : keys) {
            if (map.get(ke.getKey()) > frequency) {
                tmp.add((String) ke.getKey());
            }
        }
        return tmp;

    }

    public void printAcs() {
        Collection collValues = map.values();
        ArrayList<Integer> vals = new ArrayList<>();
        for (Object o : collValues) {
            vals.add((int) o);
        }
        HashSet<Integer> sortedVals = new HashSet<>();
        for (int i : vals){
            sortedVals.add(i);
        }
        Set<String> keys = map.keySet();
        for(int i : sortedVals){
            for(String ke : keys){
                if(map.get(ke).equals(i)){
                    System.out.println("word " +ke+ " meets in the text" + map.get(ke)+ " times");
                }
            }
        }
    }

    void printDesc() {
        Collection collValues = map.values();
        ArrayList<Integer> vals = new ArrayList<>();
        for (Object o : collValues) {
            vals.add((int) o);
        }
        vals.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ArrayList<Integer> sortedVals = new ArrayList<>();
        for (int i : vals){
            if(sortedVals.contains(i) == false){ sortedVals.add(i);}
        }
        Set<String> keys = map.keySet();
        for(int i : vals){
            for(String ke : keys){
                if(map.get(ke).equals(i)){
                    System.out.println("word " +ke+ " meets in the text" + map.get(ke)+ " times");
                }
            }
        }
    }
}



class Main{
    public static void main(String[] args) throws IOException {
        Freq fr = new Freq();
//        fr.textToMap(fr.setTextFromFile("/home/oleg/IdeaProjects/proff25/oleg_chumak/text.txt"));
//        fr.textToMap(fr.setTextFromConsole());
//        Set<String>str = fr.getWordsByFrequency(2);
//        System.out.println(fr);
//        fr.printAcs();
        for (int i = 0; i < 50; i++) {
            fr.textToMap(fr.generateRandomText(5));
        }
        fr.printAcs();
    }
}
