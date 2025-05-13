package com.example.project6;

import java.util.ArrayList;

public class Part2_1 {


    public static int recLinearSearch(ArrayList<String> list, String key, int beginIdx, int endIdx) {
        // Base case: empty list or search range exhausted
        if (list == null || list.isEmpty() || beginIdx > endIdx) {
            return -1;
        }

        if (key.equals(list.get(beginIdx))) {
            return beginIdx;
        }

        return recLinearSearch(list, key, beginIdx + 1, endIdx);
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("date");

        String searchKey = "cherry";
        int index = recLinearSearch(words, searchKey, 0, words.size() - 1);

        if (index != -1) {
            System.out.println(searchKey + " found at index " + index);
        } else {
            System.out.println(searchKey + " not found.");
        }
    }
}
