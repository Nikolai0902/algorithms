package algorithms.job4j.HashStructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * В этом задании необходимо найти все анаграммы подстроки.
 * Решение этой задачи сводиться к поиску набора символов из подстроки в целевой  строке.
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Рассмотрим минимально возможный случай входных параметров:
 * подстрока равна длине целевой строки.
 * В этом случае решение сводиться к преобразованию строки в набор HashSet.
 * Если целевая строка длиннее, чем подстрока,
 * то нам нужно разбить ее на наборы символов по длине подстроки.
 *
 *
 */
public class FindAnagram {
    public static Set<Character> toSet(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.toCollection(HashSet::new)
                );
    }

    private static List<Integer> findAnagrams(String str, String substr) {
        var result = new ArrayList<Integer>();
        var anagrams = toSet(substr);
        int windowSize = substr.length();
        for (int i = 0; i <= str.length() - windowSize; i++) {
            String window = str.substring(i, i + windowSize);
            if (anagrams.equals(toSet(window))) {
                result.add(i);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagramIndices = findAnagrams(s, p);
        System.out.println(anagramIndices);

        String f = "aaabbbaaabbb";
        String a = "bbb";
        List<Integer> anagramIndices1 = findAnagrams(f, a);
        System.out.println(anagramIndices1);

    }
}
