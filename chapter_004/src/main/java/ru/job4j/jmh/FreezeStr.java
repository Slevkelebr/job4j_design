package ru.job4j.jmh;

import java.util.Arrays;

public class FreezeStr {

    public static boolean eqCheckChar(String left, String right) {
        boolean rsl = true;
        if(left.length() != right.length()) {
            return false;
        }
        char[] ch1 = left.toCharArray();
        char[] ch2 = right.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++)
            if (ch1[i] != ch2[i])
                rsl = false;
        return rsl;
    }

    public static boolean eqSort(String left, String right) {
        int[] letters = new int[256];

        char[] left_array = left.toCharArray();
        for (char c : left_array) {
            letters[c]++;
        }

        for (int i = 0; i < right.length(); i++) {
            int c = right.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

}
