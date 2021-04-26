package me.hammer86gn.djar.utils;

public class Util {

    public static int countCharOccurrences(char charToCheck, String stringToCheck) {
        int count = 0;

        for (int i = 0;  i < stringToCheck.length(); i++) {
            if (stringToCheck.charAt(i) == charToCheck) {
                count++;
            }
        }
        return count;
    }

}
