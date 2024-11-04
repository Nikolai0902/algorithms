package algorithms.job4j.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Вам необходимо разработать алгоритм нахождение наименьшего
 * диапазона с данным количеством различных элементов
 * <p>
 * У вас есть отсортированный массив целых чисел и число k.
 * Ваша задача - найти наименьший диапазон в массиве,
 * который содержит как минимум k различных элементов. Напримеры:,
 * <p>
 * входной массив [1, 2, 3, 4, 5] и k = 3, то наименьший диапазон будет [0, 2],
 * так как он содержит три различных элемента: 1, 2 и 3.
 * <p>
 * входной массив [1, 2, 2, 3, 4, 5] и k = 3, то наименьший диапазон будет [2, 4],
 * так как он содержит три различных элемента: 2, 3 и 4. Диапазон [0, 2] не подходит,
 * так как он содержит дублирующие элементы 1, 2, 2.
 */
public class SmallestRangeFinder {

    /**
     * Нацелен на нахождение наименьшего диапазона (подмассива),
     * содержащего как минимум k различных элементов.
     * Он возвращает индексы начала и конца этого диапазона.
     *
     *  Внутренний цикл (while) продолжает выполняться до тех пор,
     *  пока количество уникальных элементов в текущем диапазоне не станет меньше k.
     *  Это позволяет находить наименьший диапазон с необходимым количеством уникальных элементов.
     *
     *  Указатель left сдвигается во время выполнения внутреннего цикла,
     *  чтобы уменьшить размер диапазона,
     *  когда найдено необходимое количество уникальных элементов.
     *
     * Временная сложность: O(n); Пространственная сложность: O(k).
     */
    public static int[] findSmallestRangeVarOne(int[] nums, int k) {
        Map<Integer, Integer> memory = new HashMap<>();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        for (int right = 0; right < nums.length; right++) {
            memory.put(nums[right], memory.getOrDefault(nums[right], 0) + 1);
            while (memory.size() >= k) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                    end = right;
                }
                memory.put(nums[left], memory.get(nums[left]) - 1);
                if (memory.get(nums[left]) == 0) {
                    memory.remove(nums[left]);
                }
                left++;
            }
        }

        return new int[]{start, end};
    }

    /**
     * Нацелен на поиск первого подмассива фиксированной длины k,
     * который содержит ровно k различных элементов.
     * Если такой подмассив найден, он сразу возвращает индексы.
     *
     * Проверка происходит только на равенство memory.size() == k, и если это условие выполняется,
     * алгоритм сразу возвращает результат, не пытаясь найти более короткие диапазоны.
     * В случае отсортированного массива результат схожий с первым.
     *
     * Указатель left сдвигается только тогда, когда длина текущего подмассива достигает k (ight - left == k, т.е 4 если k=3),
     * что означает, что он всегда работает с подмассивом фиксированной длины.
     *
     * Временная сложность: O(n); Пространственная сложность: O(k).
     */
    public static int[] countGoodSubstringsVarTwo(int[] nums, int k) {
        HashMap<Integer, Integer> memory = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            memory.put(nums[right], memory.getOrDefault(nums[right], 0) + 1);
            if (right - left == k) {
                memory.put(nums[left], memory.get(nums[left]) - 1);
                if (memory.get(nums[left]) == 0) {
                    memory.remove(nums[left]);
                }
                left++;
            }

            if (memory.size() == k) {
                return new int[]{left, left + k - 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Наименьший диапазон:" + Arrays.toString(findSmallestRangeVarOne(nums1, 3)));

        int[] nums2 = {1, 2, 3, 3, 5, 6, 7};
        System.out.println("Наименьший диапазон:" + Arrays.toString(findSmallestRangeVarOne(nums2, 4)));

        int[] nums3 = {1, 2, 2, 3, 4, 5};
        System.out.println("Наименьший диапазон:" + Arrays.toString(findSmallestRangeVarOne(nums3, 3)));


        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println("Наименьший диапазон:" + Arrays.toString(countGoodSubstringsVarTwo(nums4, 3)));

        int[] nums5 = {1, 2, 3, 3, 5, 6, 7};
        System.out.println("Наименьший диапазон:" + Arrays.toString(countGoodSubstringsVarTwo(nums5, 4)));

        int[] nums6 = {1, 2, 2, 3, 4, 5};
        System.out.println("Наименьший диапазон:" + Arrays.toString(countGoodSubstringsVarTwo(nums6, 3)));
    }
}
