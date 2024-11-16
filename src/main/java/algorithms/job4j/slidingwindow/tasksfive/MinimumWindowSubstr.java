package algorithms.job4j.slidingwindow.tasksfive;

import java.util.HashMap;

/**
 * 5 задача (HARD)
 *
 * Алгоритм скользящее окно
 *
 * На вход дано две строки, нужно вернуть минимальную строку подстроки s,
 * так что каждый элемент в t, находится в этом окне, если подстроки нет, вернуть пустую строку.
 *
 * input: "ADOBECODEBANC" t="ABC"
 * output: "BANC"
 * Explantation: "BANC" минимум "A", "B", "C".
 *
 * input: "a" t="aa"
 * output: ""
 *
 * Решение:
 * 1 подстрока это "ADOBEC", но нам нужна минимальная.
 * Сдесь говорится, найти окно, т.е. намекают на алгоритм СО.
 * Граница будет динамическая, нам нужна минимальная.
 * Проходим правым указателем и совершаем валидацию. Валидация -
 * является ли подстрока в окне которая содержит все символы t.
 *
 * Нам нужно задаться готовым Set, который содержит "A-1, B-1, C-1" и
 * по мере прохода по строке уменьшать его. size становится 0, все элементы присутсвуют.
 *
 * Как только получили ответ, но нам нужно найти минимальный, теперь мы пытаемся сузить ее.
 * Двигаем левый указатель и добавляем в Set A-1, теперь продолжаем двигать правый пойнтер.
 *
 * Временная сложность O(t) + O (s)
 * Пространственная сложность: O(1)
 *
 */
public class MinimumWindowSubstr {

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> memory = new HashMap<>();
        int left = 0;
        int[] res = {0, Integer.MAX_VALUE};
        int curSize = 0;

        for (char charT : t.toCharArray()) {
            memory.put(charT, memory.getOrDefault(charT, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            if (memory.containsKey(curChar)) {
                memory.put(curChar, memory.get(curChar) - 1);
                if (memory.get(curChar) == 0) {
                    curSize++;
                }
            }

            while (curSize == memory.size()) {
                int curLen = right - left;
                int prevLen = res[1] - res[0];

                if (curLen < prevLen) {
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                if (memory.containsKey(leftChar)) {
                    if (memory.get(leftChar) == 0) {
                        curSize--;
                    }
                    memory.put(leftChar, memory.get(leftChar) + 1);
                }
                left++;
            }
        }

        if (res[1] == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(res[0], res[1] + 1);
    }

    public static void main(String[] args) {
        String testString = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(testString, t);
        System.out.println("Результат: " + result);
    }
}
