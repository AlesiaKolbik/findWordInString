package com.testpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку, состоящую из слов:");
        String specifiedString = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите слово:");
        String specifiedWord = scanner1.nextLine();
        ArrayList<String> stringArrayList = split(specifiedString);
        String lastElementWord = String.valueOf(specifiedWord.charAt(specifiedWord.length()-1));
        int noMatches = 0;
        int lengthArray = stringArrayList.size();
        for (int i = 0; i < lengthArray; i++) {
            stringArrayList.get(i).endsWith(lastElementWord);
            if (stringArrayList.get(i).endsWith(lastElementWord)) {
                System.out.println(stringArrayList.get(i));
            } else {
                noMatches++;
            }
        }
        if (noMatches == lengthArray) {
            System.out.println("Совпадений на " + lastElementWord + " не найдено.");
        }
    }
    private static ArrayList<String> split(String string) {
        String separator=" ";
        ArrayList<String> stringArray=new ArrayList<>();
        for(int i=0; i<string.length();i++){
            int startInd=findNextIndexWord(string,i,separator);
            int endInd=findLastIndexWord(string,startInd , separator);
            String word=cutWord(string,startInd,endInd);
            stringArray.add(word);
            i=endInd;
        }
        return stringArray;
    }



    private static String cutWord(String string, int startInd, int endInd) {
        String word = "";
        for (int i = startInd; i < endInd; i++) {
            word += string.charAt(i);
        }
        return word;
    }

    private static int findLastIndexWord(String string, int index, String separator) {
        while (!separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
            if(index==string.length()-1)
                break;
        }
        return index;
    }

    private static int findNextIndexWord(String string, int index, String separator) {
        while (separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
        }
        return index;
    }

}
