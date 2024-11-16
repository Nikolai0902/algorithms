package algorithms.job4j.slidingwindow.tasksFive;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 4 задача
 *
 * Алгоритм скользящее окно
 *
 * Нужно вернуть длинну самуой длинной подстроки в которой хранится
 * максимальное колличество K различных элементов.
 *
 * input: "eceba" k=2
 * output: 3
 * Explantation: "ece" is 3
 *
 * input: "aa" k=1
 * output: 2
 * Explantation: "aa" is 2
 *
 * Временная сложность O(n) - проходимся 1 раз,
 * Пространственная сложность: O(n) - мы используем по памяти только HashMap, не больше чес ключей K,
 * как только она становиться больше, мы удаляем. Т.е. O зависит от k.
 */
public class SubstringSizeMaxKElement {

    public static int countGoodSubstrings(String s, int k) {
        HashMap<Character, Integer> memory = new HashMap<>();
        int left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            memory.put(curChar, memory.getOrDefault(curChar, 0) + 1);
            while (memory.size() > k) {
                char leftChar = s.charAt(left);
                memory.put(leftChar, memory.get(leftChar) - 1);
                if (memory.get(leftChar) == 0) {
                    memory.remove(leftChar);
                }
                left++;
            }
            res = Integer.max(right - left + 1, res);
        }

        return res;
    }

    public static void main(String[] args) {
        String testString = "ccaabbb";
        int result = countGoodSubstrings(testString, 2);
        System.out.println("Результат: " + result);
    }
}
