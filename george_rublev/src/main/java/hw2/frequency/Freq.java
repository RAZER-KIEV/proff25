package hw2.frequency;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by george on 31.05.15.
 */
public class Freq {

    Map<String, Integer> data = new HashMap<>();

    private String clear(String text) {
        char[] charArray ={ '!', '@', '#', '.', ',','$', '%', '^', '&', '*', '(', ')', '_', '-', '=','!', '`', '~', '/', '{','}','[',']',';',':','"','?','>','<'};
        for(char c:charArray){
            text=text.replace(Character.toString(c),"");
        }
        text=text.replace("  "," ");
        return text;
    }

    //ввести текст с консоли
    public String setTextFromConsole(){
        data.clear();
        System.out.println("Enter text");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        tmp = clear(tmp);
        addToData(tmp);
        System.out.println(tmp);
        printAcs();
        System.out.println(data);
        return scanner.nextLine();
    }

    //задать файл с текстом
    public String setTextFromFile(String fileName){
        data.clear();
        try {

            FileReader fr = new FileReader(fileName);
            Scanner scanner = new Scanner(fr);
            scanner.useDelimiter("[ ,"+System.lineSeparator()+".!?]+");
            while (scanner.hasNext()) {
                addToData(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "";
    }

    private void addToData(String s) {
        System.out.println(s);
        String[] buf = s.split(" ");
        for(int i = 0; i<buf.length;i++){
            if(data.get(buf[i])==null){
                data.put(buf[i],1);
            }
            else{
                int tmp = data.get(buf[i]);
                tmp++;
                data.put(buf[i],tmp);
            }
        }
    }



    //генерировать случайный текст
    public String generateRandomText(int textLength){
        data.clear();
        String str = "";
        for (int i = 0; i < textLength; i++) {
            int symbol;
            int num = 0;
            do {
                symbol = 97 + (int)(Math.random()*26);
                str = str + (char)symbol;
                num++;
            } while (symbol != 125 && num < 10);
            addToData(str);
            str = str + " ";
        }
        System.out.println(str);
        return str;
    }

    //получить слова по частоте
    public Set<String> getWordsByFrequency(int frequency){
        Set<String> strings = new HashSet<>();

        for(Map.Entry<String, Integer> en : data.entrySet()) {
            if (en.getValue()==frequency)
                strings.add(en.getKey());
        }
        return strings;
    }

    //получить слова, частотой менее
    public Set<String> getWordsByFrequencyLessThan(int frequency){
        Set<String> strings = new HashSet<>();
        for(Map.Entry<String, Integer> key : data.entrySet()) {
            if (key.getValue()<frequency)
                strings.add(key.getKey());
        }
        return strings;
    }

    //получить слова, частотой более чем
    public Set<String> getWordsByFrequencyMoreThan(int frequency){
        Set<String> strings = new HashSet<>();
        for(Map.Entry<String, Integer> key : data.entrySet()) {
            if (key.getValue()>frequency)
                strings.add(key.getKey());
        }
        return strings;
    }

    // - вывести все слова + частота. по возрастанию частоты
    public void printAcs(){
        for ( int i=1;i<=max();i++){
            Set<String> strings= getWordsByFrequency(i);
            for (String str:strings){
                System.out.println(str + " " + i);
            }
        }
    }

    // - вывести все слова + частота. по убыванию частоты
    void printDesc(){
        for ( int i=max();i>0;i--){
            Set<String> strings= getWordsByFrequency(i);
            for (String str:strings){
                System.out.println(str+" "+i);
            }
        }
    }
    private int max(){
        int max = 0;
        for(Map.Entry<String, Integer> value : data.entrySet()) {
            if (value.getValue()>max)
                max=value.getValue();
        }
        System.out.println("max value="+max);
        return max;
    }
}
class FreqTest{
    public static void main(String[] args) {
Freq freq = new Freq();
//        freq.generateRandomText(100);

        System.out.println(freq.setTextFromConsole());
    }
}