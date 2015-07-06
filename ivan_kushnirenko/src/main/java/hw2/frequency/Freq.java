package hw2.frequency;


import javax.validation.constraints.Null;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ivan on 01.07.15.
 */

public class Freq {

    private String text;

    public Freq() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private HashMap<String, Integer> getWords(String text) {
        if (text == null) {
            throw new NullPointerException("ERROR: Entry text must be non null.");
        }
        Pattern pattern = Pattern.compile("[[a-zA-Z]]+");
        Matcher matcher = pattern.matcher(text);
        HashMap<String, Integer> textWords = new HashMap<>();
        while (matcher.find()) {
            String s = matcher.group();
            s = s.toLowerCase();
            if (textWords.containsKey(s)) {
                textWords.replace(s, textWords.get(s) + 1);
            } else {
                textWords.put(s, 1);
            }
        }
        return textWords;
    }

    private List sortWords(HashMap<String, Integer> map) {
        if (text == null) {
            throw new NullPointerException("ERROR: You must read text before counting frequency of words.");
        }
        HashMap<String, Integer> words = new HashMap<>();
        words = getWords(text);
        List sortedWords = new ArrayList<>(words.entrySet());
        Collections.sort(sortedWords, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        return sortedWords;
    }

    public String setTextFromConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = null;
        System.out.println("Please, type the text.txt:");
        try {
            text = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public String setTextFromFile(String fileName) {
        Path path = Paths.get(fileName);
        SeekableByteChannel channel = null;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String text = null;
        try {
            channel = Files.newByteChannel(path);
            channel.position(0);
            int readed = channel.read(buffer);
            if (readed > 0) {
                text = new String(buffer.array(), 0, readed);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public String generateRandomText(int textLength) {
        char[] letters = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122,
                32, 32, 32, 32, 33, 33, 44, 44, 44, 46, 46, 58, 59, 63};
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(letters[random.nextInt(26)]);
        for (int i = 0; i < textLength - 2; i++) {
            if (sb.charAt(sb.length() - 1) == 33 ||
                    sb.charAt(sb.length() - 1) == 46 ||
                    sb.charAt(sb.length() - 1) == 63) {
                sb.append((char) 32);
                sb.append(letters[random.nextInt(26)]);
                i++;
            } else if (sb.charAt(sb.length() - 1) > 64 && sb.charAt(sb.length() - 1) < 91) {
                sb.append(letters[random.nextInt(26) + 32]);
            } else if (sb.charAt(sb.length() - 1) == 44 ||
                    sb.charAt(sb.length() - 1) == 58 ||
                    sb.charAt(sb.length() - 1) == 59) {
                sb.append((char) 32);
                sb.append(letters[random.nextInt(26) + 32]);
                i++;
            } else if (sb.charAt(sb.length() - 1) == 32 && sb.charAt(sb.length() - 2) > 25 && sb.charAt(sb.length() - 1) < 53) {
                sb.append(letters[random.nextInt(26) + 26]);
            } else {
                sb.append(letters[random.nextInt(40) + 26]);
                if (sb.charAt(sb.length() - 2) == 32 &&
                        (sb.charAt(sb.length() - 1) == 33 ||
                                sb.charAt(sb.length() - 1) == 46 ||
                                sb.charAt(sb.length() - 1) == 63)) {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(letters[random.nextInt(26)]);
                }
                if (sb.charAt(sb.length() - 2) == 32 &&
                        (sb.charAt(sb.length() - 1) == 44 ||
                                sb.charAt(sb.length() - 1) == 58 ||
                                sb.charAt(sb.length() - 1) == 59)) {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(letters[random.nextInt(26) + 26]);
                }
            }
        }
        if (sb.charAt(sb.length() - 1) == 32) {
            sb.deleteCharAt(sb.length() - 1);
            sb.append(letters[random.nextInt(26) + 26]);
        }
        sb.append(".");
        return new String(sb);
    }

    public Set getWordsByFrequency(int frequency) {
        if (frequency == 0 || frequency < 0) {
            throw new IllegalArgumentException("ERROR: input parameter must de positive.");
        }
        if (text == null) {
            System.out.println("ERROR: you must read the text before counting frequency of words.");
            return null;
        }
        Set wordsWithFreqThen = new HashSet<>();
        HashMap<String, Integer> words = getWords(text);
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue() == frequency) {
                wordsWithFreqThen.add(word);
            }
        }
        return wordsWithFreqThen;
    }

    public Set getWordsByFrequencyLessThan(int frequency) {
        if (frequency == 0 || frequency < 0) {
            throw new IllegalArgumentException("ERROR: input parameter must de positive.");
        }
        if (text == null) {
            System.out.println("ERROR: you must read the text before counting frequency of words.");
            return null;
        }
        Set wordsWithFreqThen = new HashSet<>();
        HashMap<String, Integer> words = getWords(text);
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue() < frequency) {
                wordsWithFreqThen.add(word);
            }
        }
        return wordsWithFreqThen;
    }

    public Set getWordsByFrequencyMoreThan(int frequency) {
        if (text == null) {
            System.out.println("ERROR: you must read the text before counting frequency of words.");
            return null;
        }
        Set wordsWithFreqThen = new HashSet<>();
        HashMap<String, Integer> words = getWords(text);
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue() > frequency) {
                wordsWithFreqThen.add(word);
            }
        }
        return wordsWithFreqThen;
    }

    public void printDesc() {
        List sortedWords = sortWords(getWords(text));
        for (int i = 0; i < sortedWords.size(); i++) {
            System.out.println(sortedWords.get(i));
        }
    }

    public void printAcs() {
        List sortedWords = sortWords(getWords(text));
        for (int i = sortedWords.size() - 1; i >= 0; i--) {
            System.out.println(sortedWords.get(i));
        }
    }

    public static void main(String[] args) {
    }
}
