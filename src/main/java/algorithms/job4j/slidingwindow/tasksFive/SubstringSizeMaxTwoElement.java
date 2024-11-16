package algorithms.job4j.slidingwindow.tasksFive;

import java.util.HashMap;

/**
 * 3 задача
 *
 * Алгоритм скользящее окно
 *
 * Нужно вернуть длинну самуой длинной подстроки в которой хранится
 * максимальное колличество 2х различных элементов.
 *
 * input: "eceba"
 * output: 3
 * Explantation: "ece" is 3
 *
 * input: "ccaabbb"
 * output: 5
 * Explantation: "aabbb" is 5
 *
 * Граница как и во втророй задаче динамическая. Итерируем по праваму указателю.
 * и делаем валидацию. Смотрим можно ли нам сдесь держать состояние, нужно, нам нужно
 * держать кооличество уникальных элементов подстроки. Set не подойдет, подойдет HasMap,
 * которая будет служить каунтером всех элементов внутри нашего окна.
 * Мы будем всегда следить что бы размер Hash таблицы равнялся двум, т.е. там было 2 уникальных ключа.
 * И мы будем двигать правый и левый пойнтер.
 *
 */
public class SubstringSizeMaxTwoElement {

    public static int countGoodSubstrings(String s) {
        HashMap<Character, Integer> memory = new HashMap<>();
        int left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            memory.put(curChar, memory.getOrDefault(curChar, 0) + 1);
            while (memory.size() > 2) {
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
        int result = countGoodSubstrings(testString);
        System.out.println("Результат: " + result);
    }
}
