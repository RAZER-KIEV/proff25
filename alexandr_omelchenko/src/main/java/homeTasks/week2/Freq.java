package homeTasks.week2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 Написать класс для вычисления частоты слов в тексте с методами:
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

    private String slova;
    public String getSlova() {
        return slova;}
    public void setSlova(String slova) {
        this.slova = slova;}

    public TreeMap<String, Integer> wordsMap = new TreeMap<>();

    public void fillHashMap (String text){
        String[] words = text.split(" ");
for(String w: words){
    if(wordsMap.containsKey(w)){int temp=wordsMap.remove(w); wordsMap.put(w, temp+1); }
    else wordsMap.put(w, 1);}
}

    public String setTextFromConsole() {
        Scanner scan = new Scanner(System.in);
        System.out.println("add text");
        String text = scan.nextLine();
        return text;
    }

    public String setTextFromFile(String fileName) throws FileNotFoundException {
        String text = "";
        Scanner scan = new Scanner(new File(fileName));
        while (scan.hasNextLine()) {
            text=text+scan.nextLine();          }
        return text;
    }
    public String generateRandomText(int textLength){
        String text="";
        Random random = new Random();
        for (int i=0; i<textLength;i++){
            text=text+Character.toString((char)(random.nextInt(25)+97));
        }
        return text;
    }
   public Set<String> getWordsByFrequency(int frequency){
Set<String> wordSet =new TreeSet<>();
        wordsMap.forEach((k, v) -> {
            if (v == frequency) {
                wordSet.add(k);
            }
        });
        return wordSet;
    }
    public Set<String> getWordsByFrequencyLessThan(int frequency){
        Set<String> wordSet =new TreeSet<>();
        wordsMap.forEach((k, v) -> {
            if (v < frequency) {
                wordSet.add(k);
            }
        });
        return wordSet;
    }
    public Set<String> getWordsByFrequencyMoreThan(int frequency){
        Set<String> wordSet =new TreeSet<>();
        wordsMap.forEach((k, v) -> {
            if (v > frequency) {
                wordSet.add(k);
            }
        });
        return wordSet;
    }
    public void printAcs(){
        Collection<Integer> val = wordsMap.values();
        ArrayList<Integer> vals = new ArrayList<>();
        for (Object o : val) {
            vals.add((int) o);
        }
        vals.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
System.out.println(vals.toString());
    }
    public void printDesc(){
        Collection<Integer> val = wordsMap.values();
        ArrayList<Integer> vals = new ArrayList<>();
        for (Object o : val) {
            vals.add((int) o);
        }
        vals.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
System.out.println(vals.toString());
    }
    public static void main(String[] args) {
        Freq test = new Freq();
        test.setSlova(test.setTextFromConsole());
        test.fillHashMap(test.getSlova());
        System.out.println(test.wordsMap.toString());

        Set<String> rezWords = test.getWordsByFrequency(3);
        /*System.out.println(rezWords.toString());
        Set<String> lessWords = test.getWordsByFrequencyLessThan(3);
        System.out.println(lessWords.toString());
        Set<String> moreWords = test.getWordsByFrequencyMoreThan(2);
        System.out.println(moreWords.toString());*/
        test.printDesc();
        test.printAcs();
    }
}