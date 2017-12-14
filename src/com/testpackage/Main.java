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
        String lastElementWord = String.valueOf(specifiedWord.charAt(specifiedWord.length() - 1));
        ArrayList<String> matches = findMatchesWithWord(stringArrayList, lastElementWord);
        printMatches(matches);
    }

        private static ArrayList<String> split (String string){
            String separator = " ";
            ArrayList<String> stringArray = new ArrayList<>();
            for (int i = 0; i < string.length(); i++) {
                int startInd = findNextIndexWord(string, i, separator);
                int endInd = findLastIndexWord(string, startInd, separator);
                String word = cutWord(string, startInd, endInd);
                stringArray.add(word);
                i = endInd;
            }
            return stringArray;
        }

    private static int findLastIndexWord(String string, int index, String separator) {
        while (!separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
            if (index == string.length() - 1)
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

    private static String cutWord(String string, int startInd, int endInd) {
        String word = "";
        for (int i = startInd; i < endInd; i++) {
            word += string.charAt(i);
        }
        return word;
    }

    private static ArrayList<String> findMatchesWithWord(ArrayList<String> stringArrayList, String symbol) {
        ArrayList<String> matches = new ArrayList<>();
        for (int i = 0; i < stringArrayList.size(); i++) {
            if (stringArrayList.get(i).endsWith(symbol)) {
                matches.add(stringArrayList.get(i));
            }
        }
        return matches;
    }

    private static void printMatches(ArrayList<String> matches) {
        if (matches.size() == 0) {
            System.out.println("Совпадений не найдено.");
        } else {
            for (int i = 0; i < matches.size(); i++) {
                System.out.println(matches.get(i));
            }
        }
    }
}
