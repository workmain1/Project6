package com.example.project6;


public class Part2_21 {


    public int binarySearch(int[] a, int search) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == search) {
                return mid; // Found
            } else if (a[mid] < search) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Not found
    }

    // Main method to test
    public static void main(String[] args) {
        Part2_21 searcher = new Part2_21();
        int[] sortedArray = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = searcher.binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Found " + target + " at index " + result);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}
