package homework2;

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
 * Created by bosyi on 30.05.15.
 */
public class Freq {

    private HashMap<String,Integer> wordsMap = new HashMap<>();

    public static void main(String[] args) {
        Freq task = new Freq();
        String[] strings = task.parseWords(task.setTextFromFile("bogdan_iavorskyi/text"));
        task.generateMap(strings);
//        Set<String> stringTreeSet = task.getWordsByFrequencyMoreThan(0);
//        stringTreeSet.forEach(s -> System.out.println(s));
        task.printDesc();
    }

    public void generateMap(String[] words) {
        for (String s:words) {
            if (wordsMap.containsKey(s)) {
                wordsMap.compute(s, (k, v) -> v = v + 1);
            } else {
                wordsMap.put(s,1);
            }
        }
    }

    public Set<String> getWordsByFrequency(int frequency) {
        Set<String> words = new TreeSet<>();
        wordsMap.forEach((k, v) -> {
            if (v == frequency) {
                words.add(k);
            }
        });
        return words;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<String> words = new TreeSet<>();
        wordsMap.forEach((k, v) -> {
            if (v > frequency) {
                words.add(k);
            }
        });
        return words;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> words = new TreeSet<>();
        wordsMap.forEach((k, v) -> {
            if (v < frequency) {
                words.add(k);
            }
        });
        return words;
    }

    public void printAcs() {
        Comparator<Map.Entry<String, Integer>> comAcs = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue()) == -1 ? -1 : 1;
            }
        };
        TreeSet<Map.Entry<String, Integer>> entries = new TreeSet<>(comAcs);
        entries.addAll(wordsMap.entrySet());
        System.out.print("[");
        entries.forEach(stringIntegerEntry -> System.out.print(stringIntegerEntry.getKey() + ", "));
        System.out.println("]");
    }

    public void printDesc() {
        Comparator<Map.Entry<String, Integer>> comAcs = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue()) == -1 ? 1 : -1;
            }
        };
        TreeSet<Map.Entry<String, Integer>> entries = new TreeSet<>(comAcs);
        entries.addAll(wordsMap.entrySet());
        System.out.print("[");
        entries.forEach(stringIntegerEntry -> System.out.print(stringIntegerEntry.getKey() + ", "));
        System.out.println("]");
    }

    public String setTextFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String resultingString = "";
        String string;
        System.out.println("Enter line of some text:");
        resultingString+=scanner.nextLine();
        System.out.println("Enter next line of some text or -1 to exit");
        string = scanner.nextLine();
        while (!string.equals("-1")) {
            resultingString+=" " + string;
            System.out.println("Enter next line of some text or -1 to exit");
            string = scanner.nextLine();
        }
        return resultingString;
    }

    public String setTextFromFileWithByteBuffer(String fileName) {
        Path path = Paths.get(fileName);
        try (SeekableByteChannel channel = Files.newByteChannel(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String setTextFromFile(String fileName) {
        String resultingString = "";
        try (FileReader fileReader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                resultingString+=scanner.nextLine() + " ";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return resultingString;
        }
    }

    public String[] parseWords(String text) {
        String[] words = text.split("[^a-zA-Z]+");
        for(int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        return words;
    }
}
