package com.moni;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairsCounter {

    private String input;
    private Map<String, Integer> map = new HashMap<String, Integer>();

    private void readInput(){
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
    }

    private void countingPairs() {
        readInput();
        int frequencyCounter = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            char firstChar = input.charAt(i);
            char secondChar = input.charAt(i + 1);
            String pair = String.valueOf(input.charAt(i)) + String.valueOf(input.charAt(i + 1));
            String reversedPair = String.valueOf(input.charAt(i + 1)) + String.valueOf(input.charAt(i));
            if (Character.isLetter(firstChar) & Character.isLetter(secondChar)) {
                if (map.containsKey(pair)) {
                    int currentValue = map.get(pair);
                    map.put(pair, currentValue + 1);
                } else if (map.containsKey(reversedPair)) {
                    int oldValue = map.get(reversedPair);
                    map.put(reversedPair, oldValue + 1);
                } else {
                    map.put(pair, frequencyCounter);
                }
            }
        }
    }

    private void sortPairs() {
        countingPairs();
        System.out.println("Most common pairs:");
        for (int i = 0; i < 3; i++) {
            Map.Entry<String, Integer> maxEntry = null;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }
            System.out.println(maxEntry);
            if (map.containsValue(maxEntry.getValue())) {
                map.remove(maxEntry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        PairsCounter counter = new PairsCounter();
        counter.sortPairs();
    }
}

