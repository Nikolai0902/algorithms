package algorithms.job4j.TwoPointers;

import java.util.Arrays;

/**
 * Дан отсортированный массив от большего к меньшему. Нужно возвести каждый элемент в квадрат,
 * чтобы результирующий массив был тоже отсортирован. В задаче нужно использовать алгоритм двух указателей.
 *
 * Решение этой задачи с использованием алгоритма двух указателей
 * довольно простое. Основная идея заключается в том, что мы будем двигаться по массиву
 * с двух сторон: с начала и с конца, возводя элементы в квадрат и помещая их в результирующий массив.
 *
 * Вот шаги алгоритма:
 *
 * Создайте результирующий массив той же длины, что и исходный массив.
 * Установите два указателя: один указывает на начало исходного массива, а другой - на его конец.
 * Начните двигаться по массиву с обоих концов, возводя элементы в квадрат и помещая их в результирующий массив.
 * Следите за тем, чтобы значения в результирующем массиве шли от большего к меньшему.
 *
 * Это решение будет иметь временную сложность O(n), где n - количество элементов в исходном массиве,
 * так как мы пройдемся только один раз по каждому элементу массива.
 */
public class SQR {
    public static int[] squareSortedArray(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int resultIndex = arr.length - 1;

        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                result[resultIndex] = arr[left] * arr[left];
                left++;
            } else {
                result[resultIndex] = arr[right] * arr[right];
                right--;
            }
            resultIndex--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {-4, -2, 0, 2, 3, 5};
        int[] resultArray = squareSortedArray(sortedArray);
        System.out.println(Arrays.toString(resultArray));
    }
}
