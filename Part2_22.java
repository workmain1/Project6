package com.example.project6;


public class Part2_22 {


    public int recursiveBinarySearch(int[] a, int search, int low, int high) {
        if (low > high) {
            return -1; // Base case: not found
        }

        int mid = (low + high) / 2;

        if (a[mid] == search) {
            return mid; // Found
        } else if (a[mid] < search) {
            return recursiveBinarySearch(a, search, mid + 1, high); // Search right half
        } else {
            return recursiveBinarySearch(a, search, low, mid - 1); // Search left half
        }
    }


    public static void main(String[] args) {
        Part2_22 searcher = new Part2_22();
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13};
        int target = 9;

        int result = searcher.recursiveBinarySearch(sortedArray, target, 0, sortedArray.length - 1);

        if (result != -1) {
            System.out.println("Found " + target + " at index " + result);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}

