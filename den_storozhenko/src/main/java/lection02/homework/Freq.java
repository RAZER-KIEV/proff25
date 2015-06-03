package lection02.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Freq {
    private Map<String, Integer> map;


    public Freq() {
        map = new HashMap<>();
    }

    public  String setTextFromConsole(){
        Scanner scanner = new Scanner(System.in);
        String text="";
        text += scanner.nextLine()+"\n";
        parseText(text);
        return text;
    }

    public  String setTextFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String text="";
        while (scanner.hasNext()){
            text+=scanner.nextLine()+"\n";
        }
        parseText(text);
        return text;
    }

    public String generateRandomText(int textLength){
        Random random = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyz                 \n\t$$$$$ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < textLength; i++) {
            char c = characters.charAt(random.nextInt(characters.length()-1));
            sb.append(c);
        }
        parseText(sb.toString());
        return sb.toString();
    }

    private void parseText(String text){
        int i=0;
        String word;
        String characters = "\n \t$";
        while (i<text.length()){
            word="";
            while (i<text.length() && !characters.contains(Character.toString(text.charAt(i)))){
                word+=text.charAt(i++);
            }
            if (!word.isEmpty()) {
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    int count = map.get(word);
                    map.remove(word);
                    map.put(word, ++count);
                }
            }
            i++;
        }
    }

    public Set<String> getWordsByFrequency(int frequency){
        Set<String> strings = new HashSet<>();
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue()==frequency)
                strings.add(e.getKey());
        }
        return strings;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency){
        Set<String> strings = new HashSet<>();
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue()<frequency)
                strings.add(e.getKey());
        }
        return strings;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency){
        Set<String> strings = new HashSet<>();
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue()>frequency)
                strings.add(e.getKey());
        }
        return strings;
    }

    private int getMaxFrequency(){
        int max = 0;
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue()>max)
                max=e.getValue();
        }
        return max;
    }

    public void printDesc(){
        for ( int i=getMaxFrequency();i>0;i--){
            Set<String> strings= getWordsByFrequency(i);
            for (String str:strings){
                System.out.println(str+" "+i);
            }
        }
    }

    public void printAcs(){
        for ( int i=1;i<=getMaxFrequency();i++){
            Set<String> strings= getWordsByFrequency(i);
            for (String str:strings){
                System.out.println(str + " " + i);
            }
        }
    }
}

class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Freq freq = new Freq();
        System.out.println(freq.generateRandomText(1000));
        System.out.println("RES: ");
        freq.printDesc();
    }
}