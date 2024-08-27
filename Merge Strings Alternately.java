/**
 * The Solution class provides a method to merge two strings alternately.
 * It includes helper methods to handle different scenarios based on the
 * lengths of the input strings.
 */
class Solution {

    /**
     * Merges two strings alternately when they have the same length.
     * @param a The first string.
     * @param b The second string.
     * @return A new string where characters from `a` and `b` are interleaved.
     */
    private static String equal(String a, String b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            char first = a.charAt(i);
            char second = b.charAt(i);
            sb.append(first);
            sb.append(second);
        }
        return sb.toString();
    }

    /**
     * Merges two strings alternately when the first string is longer than the second.
     * The excess characters from the first string are appended at the end.
     * @param a The first string (longer string).
     * @param b The second string (shorter string).
     * @return A new string where characters from `a` and `b` are interleaved,
     *         followed by the remaining characters of `a`.
     */
    private static String firstGreater(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int remaining = a.length() - b.length();
        int start_index = a.length() - remaining;
        String temp = "";
        for (int i = start_index; i < a.length(); i++) {
            char c = a.charAt(i);
            temp += c;
        }
        
        for (int i = 0; i < b.length(); i++) {
            char first = a.charAt(i);
            char second = b.charAt(i);
            sb.append(first);
            sb.append(second);
        }
        sb.append(temp);
        return sb.toString();
    }

    /**
     * Merges two strings alternately when the second string is longer than the first.
     * The excess characters from the second string are appended at the end.
     * @param a The first string (shorter string).
     * @param b The second string (longer string).
     * @return A new string where characters from `a` and `b` are interleaved,
     *         followed by the remaining characters of `b`.
     */
    private static String secondGreater(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int remaining = b.length() - a.length();
        int start_index = b.length() - remaining;
        String temp = "";
        for (int i = start_index; i < b.length(); i++) {
            char c = b.charAt(i);
            temp += c;
        }
        
        for (int i = 0; i < a.length(); i++) {
            char first = a.charAt(i);
            char second = b.charAt(i);
            sb.append(first);
            sb.append(second);
        }
        sb.append(temp);
        return sb.toString();
    }

    /**
     * Merges two strings alternately based on their lengths.
     * @param word1 The first string.
     * @param word2 The second string.
     * @return A new string where characters from `word1` and `word2` are interleaved,
     *         and any remaining characters from the longer string are appended at the end.
     */
    public String mergeAlternately(String word1, String word2) {
        if (word1.length() == word2.length()) {
            return equal(word1, word2);
        } else if (word1.length() > word2.length()) {
            return firstGreater(word1, word2);
        } else {
            return secondGreater(word1, word2);
        }
    }
}
