package Homework2.frequency;

import scala.collection.Set;

import java.util.Scanner;

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

 public String setTextFromConsole(){
  Scanner scanner = new Scanner(System.in);
     text = "";
     while(scanner.hasNext())
     {
         text += scanner.nextLine();
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

 public String generateRandomText(int textLength){
  return text;
 }

 public Set<String> getWordsByFrequency(int frequency){
  return null;
 }
 public Set<String> getWordsByFrequencyLessThan(int frequency){
  return null;
 }
 public Set<String> getWordsByFrequencyMoreThan(int frequency){
  return null;
 }
 public void printAcs(){

 }

 public String getText() {
  return text;
 }

public void printDesc() {

}

}

class FreqTest {
 public static void main(String[] args) {
  Freq freq = new Freq();
  System.out.println(freq.setTextFromConsole());
 }
}
