package Homework2.frequency;

import java.util.*;

/**
 * Created by Sveta on 5/30/2015.
 * Написать класс для вычисления частоты слов в тексте с методами:
 - String setTextFromConsole()
 - String setTextFromFile(String fileName)
 - String generateRandomText(int textLength)
 - Set<String> getWordsByFrequency(int frequency)
 - Set<String> getWordsByFrequencyLessThan(int frequency)
 - Set<String> getWordsByFrequencyMoreThan(int frequency)
 - void printAcs() - вывести все слова + частота по возрастанию частоты
 - void printDesc() - вывести все слова + частота по убыванию частоты

 Класс задания hw2.frequency.Freq
 */
public class Freq {
    String text;
    HashMap<String, Integer> frequencies = new HashMap<String, Integer>();

    public HashMap getFrequencies(String text){
        String[] words = text.split(" ");
        for(String word: words){
            if(frequencies.containsKey(word)){
                int value = frequencies.get(word) + 1;
                frequencies.put(word, value);
            }
            else {
                frequencies.put(word, 1);
            }
        }
        return frequencies;
    }

 public String setTextFromConsole(){
  Scanner scanner = new Scanner(System.in);
     text = "";
     while(scanner.hasNext())
     {
         if(scanner.next() != "end!") {
             text += scanner.nextLine();
         }
         break;
     }
     return  text;
 }

 public String setTextFromFile(String fileName){
  Scanner scanner = new Scanner(fileName);
     text = "";
     while(scanner.hasNext())
     {
         text += scanner.nextLine();
     }

  return text;
 }

 public String generateRandomText(){
     char[] chars = "abc def ghi jkl mno pqr stu vwx yz ".toCharArray();
     StringBuilder sb = new StringBuilder();
     Random random = new Random();
     for (int i = 0; i < 2000; i++) {
         char aChar = chars[random.nextInt(chars.length)];
         sb.append(aChar);
     }
     text = sb.toString();

  return text;
 }

 public Set<String> getWordsByFrequency(int frequency){
     Set<String> result = null;
     Map words = getFrequencies(text);
     Set<String> keys = words.keySet();
     for(String word: keys){
         if((int)words.get(word) == frequency){
             result.add(word);
         }
     }

     return result;
 }
 public Set<String> getWordsByFrequencyLessThan(int frequency){
     Set<String> result = null;

     Map words = getFrequencies(text);
     Set<String> keys = words.keySet();
     for(String word: keys){
         if((int)words.get(word) < frequency){
             result.add(word);
         }
     }

     return result;
 }
 public Set<String> getWordsByFrequencyMoreThan(int frequency){
     Set<String> result = null;

     Map words = getFrequencies(text);
     Set<String> keys = words.keySet();
     for(String word: keys){
         if((int)words.get(word) > frequency){
             result.add(word);
         }
     }

     return result;
 }
    public void printAcs(){
        Map<String, Integer> words = getFrequencies(text);

        Map<String, Integer> mapSort = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return words.get(str1).compareTo(words.get(str2));
            }
        });
        mapSort.putAll(words);
        for(Map.Entry<String, Integer> entry : mapSort.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public void printDesc(){
        Map<String, Integer> words = getFrequencies(text);

        Map<String, Integer> mapSort = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return words.get(str2).compareTo(words.get(str1));
            }
        });
        mapSort.putAll(words);
        for(Map.Entry<String, Integer> entry : mapSort.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }


}

class FreqTest {
    public static void main(String[] args) {
        Freq freq = new Freq();
        String text = freq.setTextFromConsole();
        Map<String,Integer> map = freq.getFrequencies(text);
        System.out.println(map);

        freq.printAcs();
        freq.printDesc();
    }
}
