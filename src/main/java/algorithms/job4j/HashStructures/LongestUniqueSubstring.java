package algorithms.job4j.HashStructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Задана строка s, необходимо найти самую длинную подстроку состоящую из уникальных элементов.
 *
 * Задача так же решается алгоритмом скользящее окно.
 *
 * * Временная сложность: O(n); Пространственная сложность: O(k).
 */
public class LongestUniqueSubstring {

    public static String longestUniqueSubstring(String str) {
        Set<Character> memory = new HashSet<>();
        int left = 0;
        var result = str.substring(0, 1);

        for (int right = 0; right < str.length(); right++) {
            var curChar = str.charAt(right);
            while (memory.contains(curChar)) {
                var charLeft = str.charAt(left);
                memory.remove(charLeft);
                left++;
            }

            memory.add(curChar);

            var subString = str.substring(left, right + 1);

            if (result.length() < subString.length()) {
                result = subString;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str1 = "abcde"; // abcde
        System.out.println("Сама длинная подстрока из str = abcde ->" + longestUniqueSubstring(str1));

        String str2 = "abcbcde"; // bcde
        System.out.println("Сама длинная подстрока из str = abcbcde ->" + longestUniqueSubstring(str2));

        String str3 = "aaaaa"; // a
        System.out.println("Сама длинная подстрока из str = aaaaa ->" + longestUniqueSubstring(str3));
    }
}
