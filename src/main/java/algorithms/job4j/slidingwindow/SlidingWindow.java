package algorithms.job4j.slidingwindow;

/**
 * Алгоритм скользящее окно.
 *
 * Рассмотрим задачу поиска максимальной суммы подмассива фиксированного размера k.
 *
 * Пошаговая реализация
 * 1. **Инициализация окна**:
 *    - Сначала суммируем элементы первого окна (первых k элементов массива).
 * 2. **Скольжение окна**:
 *    - Затем сдвигаем окно на один элемент вправо,
 *    обновляя сумму, вычитая элемент, который выходит из окна, и добавляя элемент, который входит в окно.
 */
public class SlidingWindow {

    public static int maxSum(int[] nums, int k) {
        if (nums.length < k) return 0;

        int maxSum = 0;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        System.out.println("Максимальная сумма подмассива длиной " + k + " равна " + maxSum(arr, k));
    }
}
