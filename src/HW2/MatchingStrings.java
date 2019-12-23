package HW2;

/**
 * Problem 2: Solution
 */

import java.util.Arrays;

public class MatchingStrings {

    private static String[] orderArr(String[] str) {
        String temp;
        System.out.println("Strings in sorted order:");
        for (int j = 0; j < str.length; j++) {
            for (int i = j + 1; i < str.length; i++) {
                // comparing adjacent strings
                if (str[i].compareTo(str[j]) < 0) {
                    temp = str[j];
                    str[j] = str[i];
                    str[i] = temp;
                }
            }
        }
        return str;
    };

    private static String compareArraysReturntheMissing(String[] first, String[] second, int n, int m) {
        for (int i = 0; i < n; i++)
        {
            int j;
            for (j = 0; j < m; j++)
                if (first[i] != second[j])
                    return second[j];
                    break;
        }
        return "";
    };

    public static void main(String[] args) {
        String[] N = {"a11", "a2", "a4", "a3"};
        String[] B = {"b11", "b1", "b3", "b2", "b4"};

        System.out.println(Arrays.toString(N));
        System.out.println(Arrays.toString(B));
        String[] orderedN = orderArr(N);
        System.out.println(Arrays.toString(orderedN));
        String[] orderedB = orderArr(B);
        System.out.println(Arrays.toString(orderedB));
        String missing = compareArraysReturntheMissing(orderedN, orderedB, N.length, B.length);
        System.out.println(missing + ": Extra element in B");
    }

}
