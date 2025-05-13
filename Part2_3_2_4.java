package com.example.project6;


public class Part2_3_2_4 {

    static int callCount = 0;  

    public static int recursiveBinarySearch(int[] a, int search, int low, int high) {
        callCount++;
        System.out.println("Call #" + callCount + ": low = " + low + ", high = " + high);

        if (low > high) {
            System.out.println("  → Range exhausted, returning -1");
            return -1;
        }

        int mid = (low + high) / 2;
        System.out.println("  → mid = " + mid + ", a[mid] = " + a[mid]);

        if (a[mid] == search) {
            System.out.println("  → Match found! Returning index " + mid);
            return mid;
        } else if (search < a[mid]) {
            System.out.println("  → Searching left half: recursiveBinarySearch(a, " + search + ", " + low + ", " + (mid - 1) + ")");
            return recursiveBinarySearch(a, search, low, mid - 1);
        } else {
            System.out.println("  → Searching right half: recursiveBinarySearch(a, " + search + ", " + (mid + 1) + ", " + high + ")");
            return recursiveBinarySearch(a, search, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600};

        // Part 2.3 - Key = 10
        System.out.println("=== Part 2.3 Trace for key = 10 ===");
        callCount = 0;
        int index10 = recursiveBinarySearch(a, 10, 0, a.length - 1);
        System.out.println("Result: index = " + index10 + ", total calls = " + callCount + "\n");

        // Part 2.4 - Key = 150 (not in array)
        System.out.println("=== Part 2.4 Trace for key = 150 ===");
        callCount = 0;
        int index150 = recursiveBinarySearch(a, 150, 0, a.length - 1);
        System.out.println("Result: index = " + index150 + ", total calls = " + callCount);
    }
}
