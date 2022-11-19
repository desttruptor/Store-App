package com.example.storeapp.utils;

public class StringUtils {

    public static final String EMPTY = "";

    /**
     * Check if string is non-null, not empty or blank
     * @param in string to check
     * @return true if string non-null, not empty or blank; otherwise returns false
     */
    public static boolean isBlank(String in) {
        if (in == null) {
            return true;
        } else {
            return in.isEmpty() || in.trim().isEmpty();
        }
    }

    /**
     * Check if string is not null, empty or blank
     * @param in string to check
     * @return input if string is not null, empty or blank, otherwise returns false
     */
    public static String isNotBlank(String in) {
        if (in == null) {
            return EMPTY;
        } else {
            if (in.isEmpty() || in.trim().isEmpty()) {
                return EMPTY;
            } else {
                return in;
            }
        }
    }
}
