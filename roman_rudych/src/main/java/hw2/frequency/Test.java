package hw2.frequency;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Trying to find empty symbols
 * Created by rrudych on 28.05.15.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {

        Test t = new Test();
        System.out.println(t.getAllWorlds(t.setTextFromFile("/C:/textTest.txt")));
        System.out.println((t.getAllWorlds(t.setTextFromFile("/C:/textTest.txt")).get(10).toCharArray().toString()));
    }
    public List<String> getAllWorlds(String text) {

        List<String> list = new ArrayList<>();
        String clearText = text.replace('.', ' ').
                replace(',', ' ').
                replace('-', ' ').
                replace('!', ' ').
                replace('?', ' ').
                replace(')', ' ').
                replace('(', ' ').
                replace('"', ' ').toLowerCase().replaceAll("[\\x00-\\x1F\\x7F]", "");
        String[] wordsDevBySpace = clearText.split(" ");

        for(int i = 0; i <wordsDevBySpace.length; i++) {
            list.add(wordsDevBySpace[i]);
        }
        return list;
    }

    public String setTextFromFile(String fileName) throws FileNotFoundException {
        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);
        StringBuilder sb = new StringBuilder();
        int lineNum=0;
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
        }
        return sb.toString();
    }
}
