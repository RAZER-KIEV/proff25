package Homework2;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import javafx.util.Pair;
import scala.Char;
import sun.plugin2.applet.Applet2ClassLoaderCache;

import javax.swing.*;
import javax.swing.text.ChangedCharSetException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by just1ce on 28.05.2015.
 */
public class Freq {
    Map data;
    public Freq(){
        data= new HashMap< String, Integer>();
    }

    public String setTextFromConsole(){
        data.clear();
        System.out.println("Print Your text:");
        String tmp;
        int tmp_count;
        Scanner in = new Scanner(System.in);
        tmp = in.nextLine();
        tmp=cleanText(tmp);
        String[] words=tmp.split(" ");
        for(String word:words)
        {

            if(!data.containsKey(word)){
                data.put(word,1);
            }
            else{
                tmp_count = (Integer) data.get(word);
                data.replace(word,tmp_count,tmp_count+1);
            }
        }
        return tmp;
    }
    public String setTextFromFile(String fileName) throws IOException {
        String allText="";
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        int tmp_count;
        for(String line: lines){
            allText+=line;
            line=cleanText(line);
            String[] words=line.split(" ");
            for(String word:words)
            {

                if(!data.containsKey(word)){
                    data.put(word,1);
                }
                else{
                    tmp_count = (Integer) data.get(word);
                    data.replace(word,tmp_count,tmp_count+1);
                }
            }
        }
        return allText;
    }
    public String generateRandomText(int textLength){
        int tmp_count=0;
        Random r= new Random();
        int k=0,l;
        String tmp;
        StringBuilder text= new StringBuilder();
        while(k<=textLength){
            l=r.nextInt(6)+1;
            k+=l;
            tmp=getrandomWord(l);
            text.append(" ");
            text.append(tmp);
        }
        System.out.println(text);
        String[] words=text.toString().split(" ");
        for(String word:words)
        {

            if(!data.containsKey(word)){
                data.put(word,1);
            }
            else{
                tmp_count = (Integer) data.get(word);
                data.replace(word,tmp_count,tmp_count+1);
            }
        }
        return text.toString();
    }
    private String getrandomWord(int lenght){
        Random r= new Random();
        char c;
        char[] charArray= new char[lenght];
        for(int i=0;i<lenght;i++) {
            c = (char) (r.nextInt(26)+'a');
            charArray[i]=c;
        }
        String word = new String(charArray);
        return  word;

    }
    public Set<String> getWordsByFrequency(int frequency)
    {
        Set<String> words = new HashSet();
        if(data.isEmpty())
            return null;
        Set<String> keys= data.keySet();
        for (String word: keys) {
            if((Integer) data.get(word)==frequency)
                words.add(word);
        }
        return words;
    }
    public Set<String> getWordsByFrequencyLessThan(int frequency){
        Set<String> words = new HashSet();
        if(data.isEmpty())
            return null;
        Set<String> keys= data.keySet();
        for (String word: keys) {
            if((Integer) data.get(word)<frequency)
                words.add(word);
        }
        return words;
    }
    public Set<String> getWordsByFrequencyMoreThan(int frequency){
        Set<String> words = new HashSet();
        if(data.isEmpty())
            return null;
        Set<String> keys= data.keySet();
        for (String word: keys) {
            if((Integer) data.get(word)>frequency)
                words.add(word);
        }
        return words;
    }
    public void printAcs(){
        Comparator<String> comparator= new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((Integer)data.get(o1) >= (Integer)data.get(o2)) {
                    return -1;
                } else {
                    return 1;
                } // returning 0 would merge keys
            }
        };
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(comparator);
        sorted_map.putAll(data);
        Set<String> keys = sorted_map.keySet();
        for (String word: keys) {
            System.out.print(word+" ");
            System.out.println(data.get(word).toString());
        }
    }
    public void printDesc(){
        Comparator<String> comparator= new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((Integer)data.get(o1) <= (Integer)data.get(o2)) {
                    return -1;
                } else {
                    return 1;
                } // returning 0 would merge keys
            }
        };
        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(comparator);
        sorted_map.putAll(data);
        Set<String> keys = sorted_map.keySet();
        for (String word: keys) {
            System.out.print(word+" ");
            System.out.println(data.get(word).toString());
        }
    }
    private String cleanText(String text) {
        char[] charArray ={ '!', '@', '#', '.', ',','$', '%', '^', '&', '*', '(', ')', '_', '-', '=','!', '`', '~', '/', '{','}','[',']',';',':','"','?','>','<'};
        for(char c:charArray){
            text=text.replace(Character.toString(c),"");
        }
        text=text.replace("  "," ");
        return text;
    }
}
class TestFreq{
    Freq f = new Freq();
    public void test() throws IOException {
        //f.setTextFromFile("C:\\Users\\just1_000\\IdeaProjects\\proff25\\vitaliy_zholobitskiy\\src\\main\\java\\data.txt");
        f.generateRandomText(50);
        f.printAcs();
        System.out.println("----------");
        f.printDesc();
        Set<String> set = f.getWordsByFrequencyLessThan(2);
        for (String word: set) {
            System.out.println(word);
        }
    }
}
