package hw2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


/**
 * Написать класс для вычисления частоты слов в тексте с методами:
 - String setTextFromConsole() - получение текста из консоли
 - String setTextFromFile(String fileName) - получить текст из файла
 - String generateRandomText(int textLength)  - генерировать рандомный текст
 - Set<String> getWordsByFrequency(int frequency) - получить из текста слова, встречающиеся с указанной частотой
 - Set<String> getWordsByFrequencyLessThan(int frequency) - получить из текста слова, встречающиеся с частотой менее указанной
 - Set<String> getWordsByFrequencyMoreThan(int frequency) - получить из текста слова, встречающиеся с частотой более указанной
 - void printAcs() - вывести все слова + частота по возрастанию частоты
 - void printDesc() - вывести все слова + частота по убыванию частоты

 Класс задания hw2.frequency.Freq
 * Created by lukashevich.e on 27.05.2015.
 */
public class Freq {

    private String str;

    Freq (String str) {
        this.str = str;
    }

    public static void main (String[] args) throws IOException {
        String string1 = generateRandomText(100);
        String string2 = setTextFromFile("text.txt");
        String string3 = setTextFromConsole();
        System.out.println(string1 + "\n");
        System.out.println(string2 + "\n");
        System.out.println(string3);

        Freq freq = new Freq(string2);
        System.out.println(freq.getWordsByFrequency(15));
        System.out.println(freq.getWordsByFrequencyLessThan(10));
        System.out.println(freq.getWordsByFrequencyMoreThan(10));
        freq.printAcs();
        freq.printDesc();

    }

    public Set<String> getWordsByFrequency(int frequency){
        // Получить из текста слова, встречающиеся с указанной частотой
        Set<String> hashSet = new HashSet<String>();
        for(Map.Entry<String, Integer> item : textMap(str).entrySet()){
            if(item.getValue() == frequency) {
                hashSet.add(item.getKey());
            }
        }
        return hashSet;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency){
        // Получить из текста слова, встречающиеся с частотой менее указанной
        Set<String> hashSet = new HashSet<String>();
        for(Map.Entry<String, Integer> item : textMap(str).entrySet()){
            if(item.getValue() < frequency) {
                hashSet.add(item.getKey());
            }
        }
        return hashSet;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency){
        // Получить из текста слова, встречающиеся с частотой более указанной
        Set<String> hashSet = new HashSet<String>();
        for(Map.Entry<String, Integer> item : textMap(str).entrySet()){
            if(item.getValue() > frequency) {
                hashSet.add(item.getKey());
            }
        }
        return hashSet;
    }

    public void printAcs() {
        // Вывод всех слов + частота по возрастанию частоты
        List<Map.Entry<String, Integer>> list = new ArrayList<>(textMap(str).entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()){
                    return 1;
                } else if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(list);
    }

    public void printDesc() {
        // Вывод всех слов + частота по убыванию частоты
        List<Map.Entry<String, Integer>> list = new ArrayList<>(textMap(str).entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(list);
    }

    private Map<String, Integer> textMap (String str) {
        // Вспомогоательный метод, возвращяющий карту с частотой слов в переданном тексте
        Map<String, Integer> tm = new TreeMap<>();
        String[] arrWords = str.replaceAll("[^а-яА-Я a-zA-Z 0-9]", "").split("[,;:.!?\\s]+");
        for (String word : arrWords) {
            word = word.toLowerCase();
            if (tm.containsKey(word)) {
                tm.put(word, tm.get(word) + 1);
            } else {
                tm.put(word, 1);
            }
        }
        return tm;
    }

    public static String setTextFromFile(String fileName) {
        // Получение текста из файла
        Path path = Paths.get(fileName);
        StringBuilder sb = new StringBuilder();
        try (SeekableByteChannel channel = Files.newByteChannel(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(256);
            int readed;
            while ((readed = channel.read(buffer)) > 0) {
                String line = new String(buffer.array(), 0, readed);
                sb.append(line);
                buffer.clear();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sb.toString();
    }


    public static String generateRandomText(int textLength){
        // Генерирование рандомного текста
        String str = "";
        for (int i = 0; i < textLength; i++) {
            int symbol;
            int iter = 0;
            do {
                symbol = 97 + (int)(Math.random()*29);
                if (symbol == 123) {
                    str = str + ". ";
                } else if (symbol == 124) {
                    str = str + ", ";
                } else if (symbol == 125) {
                    str = str + "\n";
                } else {
                    str = str + (char)symbol;
                }
                iter++;
            } while (symbol != 125 && iter < 7);
            str = str + " ";
        }
        return str;
    }

    public static String setTextFromConsole() throws IOException {
        // Получение текста из консоли
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.equals("END")) {
                break;
            } else {
                sb.append(str).append('\n');
            }
        }
        return sb.toString();
    }
}

class FreqTest {

}