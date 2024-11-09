package algorithms.job4j.sorting;

import java.util.Arrays;

/**
 * Сортировка слиянием реализована в рекурсивном стиле (может и в итеративном - без применения рекурсии).
 * На входе в рекурсию происходит последовательное деление массива
 * на части до получения массива из одного элемента,
 * а при выходе из рекурсии - такое же последовательное
 * слияние отсортированных массивов.
 *
 * Временная сложность: O(n log n), Пространственная сложность: O(n)
 *
 */
public class Merge {

    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = 0; i < result.length; i++) {
            if (indexLeft < left.length && indexRight < right.length) {
                if (left[indexLeft] < right[indexRight]) {
                    result[i] = left[indexLeft++];
                } else {
                    result[i] = right[indexRight++];
                }
            } else if (indexLeft < left.length) {
                result[i] = left[indexLeft++];
            } else if (indexRight < right.length) {
                result[i] = right[indexRight++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        System.out.println(Arrays.toString(mergesort(array)));
    }
}
