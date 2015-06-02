package hw2.frequency;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * �������� ����� ��� ���������� ������� ���� � ������ � ��������:
 - String setTextFromConsole()
 - String setTextFromFile(String fileName)
 - String generateRandomText(int textLength)
 - Set<String> getWordsByFrequency(int frequency)
 - Set<String> getWordsByFrequencyLessThan(int frequency)
 - Set<String> getWordsByFrequencyMoreThan(int frequency)
 - void printAcs() - ������� ��� ����� + ������� �� ����������� �������
 - void printDesc() - ������� ��� ����� + ������� �� �������� �������

 ����� ������� hw2.frequency.Freq

 * Created by rrudych on 28.05.15.
 */
public class Freq {

    private String text;
    private Map<String, Integer> wordsFreqMap = new TreeMap<>();

    public String setTextFromConsole() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type text:");
        text = scan.nextLine();
        wordsFreqToMap(getAllWorlds(text)); // write pare "word - frequency" to the Map - wordsFreqMap
        return text;
    }

    public String setTextFromFile(String fileName) throws FileNotFoundException {
        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);
        StringBuilder sb = new StringBuilder();
        int lineNum=0;
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
        }
        text = sb.toString();
        wordsFreqToMap(getAllWorlds(text)); // write pare "word - frequency" to the Map - wordsFreqMap
        return text;
    }

    public String generateRandomText(int textLength) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <textLength; i++) {
            sb.append((char)(random.nextInt(94)+32));
        }
        text = sb.toString();
        wordsFreqToMap(getAllWorlds(text)); // write pare "word - frequency" to the Map - wordsFreqMap
        return text;
    }

    public Set<String> getWordsByFrequency(int frequency) {

        Set<String> setRes = new TreeSet<>();
        for(Map.Entry<String, Integer> set: wordsFreqMap.entrySet()) {
            if(set.getValue() == frequency) {
                setRes.add(set.getKey());
            }
        }
        return setRes;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> setRes = new TreeSet<>();
        for(int i = 1; i < frequency; i++) {
            setRes.addAll(getWordsByFrequency(i));
        }
        return setRes;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<String> setRes = new TreeSet<>();
        Integer maxFrequency = getMaxFrequencyBelow(Integer.MAX_VALUE);
        for(int i = frequency + 1; i<= maxFrequency; i++) {
            setRes.addAll(getWordsByFrequency(i));
        }
        return setRes;
    }

    public void printAcs() {
        Integer minFreq = getMinFrequencyAbove(0);
        int count = wordsFreqMap.size();
        while (count != 0) {
            for (Map.Entry<String, Integer> set : wordsFreqMap.entrySet()) {
                if (set.getValue() == minFreq) {
                    System.out.println(set.getKey() + " = " + set.getValue());
                    count--;
                }
            }
            minFreq = getMinFrequencyAbove(minFreq);
        }
    }

    void printDesc() {
        Integer maxFreq = getMaxFrequencyBelow(Integer.MAX_VALUE);
        int count = wordsFreqMap.size();
        while (count != 0) {
            for (Map.Entry<String, Integer> set : wordsFreqMap.entrySet()) {
                if (set.getValue() == maxFreq) {
                    System.out.println(set.getKey() + " = " + set.getValue());
                    count--;
                }
            }
            maxFreq = getMaxFrequencyBelow(maxFreq);
        }
    }

    private List<String> getAllWorlds(String text) {
        List<String> list = new ArrayList<>();
        String clearText = text.replace('.', ' ').
                replace(',', ' ').
                replace('-', ' ').
                replace('!', ' ').
                replace('?', ' ').
                replace(')', ' ').
                replace('(', ' ').
                replace('"', ' ').toLowerCase();
        String[] wordsDevBySpace = clearText.split(" ");

        for(int i = 0; i <wordsDevBySpace.length; i++) {
            list.add(wordsDevBySpace[i]);
        }
        return list;
    }

    private void wordsFreqToMap(List<String> list) {
        int quantity;
        for(String ls: list) {
            quantity = 0;
            for(String ls2: list) {
                if(ls.equalsIgnoreCase(ls2)) {
                    quantity++;
                }
            }
            wordsFreqMap.put(ls, quantity);
        }
    }

    private Integer getMaxFrequencyBelow(Integer belowFreq) {
        Integer maxFrequency = 0;
        for(Map.Entry<String,Integer> set : wordsFreqMap.entrySet()) {
            if(set.getValue() > maxFrequency && set.getValue() < belowFreq) {
                maxFrequency = set.getValue();
            }
        }
        return maxFrequency;
    }

    private Integer getMinFrequencyAbove(Integer aboveFreq) {
        Integer minFrequency = Integer.MAX_VALUE;
        for(Map.Entry<String,Integer> set : wordsFreqMap.entrySet()) {
            if(set.getValue() < minFrequency && set.getValue() > aboveFreq) {
                minFrequency = set.getValue();
            }
        }
        return minFrequency;
    }

}
class FreqTest {
    public static void main(String[] args) throws FileNotFoundException{
        Freq fr = new Freq();
//        System.out.println(fr.setTextFromConsole());
        System.out.println(fr.setTextFromFile("/C:/textTest.txt"));
//        System.out.println(fr.generateRandomText(500));
        fr.printAcs();
        System.out.println();
        fr.printDesc();
    }
}
