package algorithms.job4j.slidingwindow.tasksfive;

import java.util.HashSet;

/**
 * 2 задача
 *
 * Алгоритм скользящее окно
 *
 * Задача на нахождение самой длинной подстроки элементы которой не повторяются.
 *
 * Начинаем проходить правым символом.
 * Для контроля уникальной строки используем Set. Если символ есть в строке удаляем левый символ и добавляем новый,
 * одновременно смещая левый указатель.
 *
 * Если нет символа в Set до добавляем.
 * В конце обхода проверяем максимальную длинну.
 *
 * Временная сложность линейная O(n) - проходимся 1 раз,
 * Пространственная сложность константа: O(1) - так как мы работаем с Set, который работает с симвалами(они ограничены алфавитом), а
 * не с int.
 */
public class SubstringSizeMax {

    public static int countGoodSubstrings(String s) {
        HashSet<Character> memory = new HashSet<>();
        int left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            while (memory.contains(curChar)) {
                char leftChar = s.charAt(left);
                memory.remove(leftChar);
                left++;
            }
            memory.add(curChar);
            res = Integer.max(right - left + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        String testString = "abcabcbb";
        int result = countGoodSubstrings(testString);
        System.out.println("Максимальная длинна в строке элементы которой не повторяются: " + result);
    }
}
