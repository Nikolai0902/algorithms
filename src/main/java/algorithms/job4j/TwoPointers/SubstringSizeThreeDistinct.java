package algorithms.job4j.TwoPointers;

import java.util.HashMap;

/**
 * Колличество хороших подстрок(с последовательными разными символами) в коде, с длинной подстроки 3.
 */
public class SubstringSizeThreeDistinct {

    // Метод для подсчета хороших подстрок длиной 3
    public static int countGoodSubstrings(String s) {
        // Хранит количество символов в текущем окне
        HashMap<Character, Integer> memory = new HashMap<>();
        // Указатели для окна: left - начало, right - конец
        int left = 0, res = 0;

        // Проходим по строке с помощью правого указателя
        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right); // Текущий символ

            // Добавляем текущий символ в память (HashMap)
            memory.put(curChar, memory.getOrDefault(curChar, 0) + 1);

            // Если длина окна превышает 3, сдвигаем левый указатель
            if (right - left == 3) {
                char leftChar = s.charAt(left); // Символ, который мы убираем из окна
                // Уменьшаем количество этого символа в памяти
                memory.put(leftChar, memory.get(leftChar) - 1);
                // Если количество этого символа стало 0, удаляем его из памяти
                if (memory.get(leftChar) == 0) {
                    memory.remove(leftChar);
                }
                left++; // Сдвигаем левый указатель вправо
            }

            // Проверяем, если у нас ровно 3 уникальных символа в окне
            if (memory.size() == 3) {
                res++; // Увеличиваем счетчик хороших подстрок
            }
        }

        return res; // Возвращаем общее количество хороших подстрок
    }

    public static void main(String[] args) {
        // Пример тестовой строки
        String testString = "bbbbacbbb";
        int result = countGoodSubstrings(testString);

        // Вывод результата
        System.out.println("Количество хороших подстрок: " + result);
    }
}
