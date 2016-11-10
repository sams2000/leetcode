package com.example.leet;

/**
 * Sort an array of numbers: [ a1, a2, …, aN ] 
 * such that when sorted:    [ s1, s2, * …, sN ]
 * 
 * the following is true: s1 <= s2 >= s3 <= s4 >= s5 <= …
 * 
 * @author bzhou3
 * @since 2016-01-09
 */
public class InterleavingSorting {
    public static void main(String[] str) {
        int[] array = { 1, 2, 3, 4, 5, 6 };
        sorting(array);
        for (int i : array) {
            System.out.print(i + ",");
        }
    }

    // integer array
    public static int[] sorting(int[] array) {
        if (array == null || array.length <= 2)
            return array;

        for (int i = 0; i < array.length - 1; i++) {
            if (i % 2 == 1) {
                if (array[i] < array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }

        return array;
    }

    public static void swap(int[] array, int i, int j) {
        // solution 1 : swap with temporary variable
        // int tmp = array[i];
        // array[i] = array[j];
        // array[j] = tmp;

        // solution 2 : swap in place
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }
}
