package algorithms.job4j.twopointers;

import java.util.HashMap;

/**
 * Колличество хороших подстрок(с последовательными разными символами) в коде, с длинной подстроки 3.
 * Решается методом скользящего окна.
 *
 * countGoodSubstrings - Метод для подсчета хороших подстрок длиной 3
 * memory - хранит количество символов в текущем окне
 * left - начало, right - конец (указатели)
 *
 * Проходим по строке с помощью правого указателя, добавляем текущий символ в память (HashMap),
 * если длина окна превышает 3, сдвигаем левый указатель - добавляем текущий символ в память (HashMap).
 *
 */
public class SubstringSizeThreeDistinct {

    public static int countGoodSubstrings(String s) {
        HashMap<Character, Integer> memory = new HashMap<>();
        int left = 0, res = 0;

        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            memory.put(curChar, memory.getOrDefault(curChar, 0) + 1);

            if (right - left == 3) {
                char leftChar = s.charAt(left);
                memory.put(leftChar, memory.get(leftChar) - 1);
                if (memory.get(leftChar) == 0) {
                    memory.remove(leftChar);
                }
                left++;
            }

            if (memory.size() == 3) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String testString = "bbbbacbbb";
        int result = countGoodSubstrings(testString);
        System.out.println("Количество хороших подстрок: " + result);
    }
}
