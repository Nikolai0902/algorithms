package algorithms.job4j.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Задан массив из интервалов. Необходимо объединить перекрывающиеся интервалы.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Временная сложность: O(n log n); Пространственная сложность: Алгоритм использует дополнительный
 * массив array размером O(n) для хранения объединенных интервалов.
 */
public class Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[][] array = new int[intervals.length][];
        array[0] = intervals[0];

        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= array[j][1]) {
                array[j][1] = interval[1];
            } else {
                j++;
                array[j] = intervals[i];
            }
        }

        return Arrays.stream(array).filter(Objects::nonNull).toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Результат объединения:" + Arrays.deepToString(new Intervals().merge(intervals1)));

        int[][] intervals2 = new int[][] { { 1, 4 }, { 4, 5 } };
        System.out.println("Результат объединения:" + Arrays.deepToString(new Intervals().merge(intervals2)));

        int[][] intervals3 = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        System.out.println("Результат объединения:" + Arrays.deepToString(new Intervals().merge(intervals3)));

        int[][] intervals4 = new int[][] { { 1, 5 }, { 2, 6 }, { 3, 7 } };
        System.out.println("Результат объединения:" + Arrays.deepToString(new Intervals().merge(intervals4)));

        int[][] intervals5 = new int[][] { { 1, 4 }, { 0, 2 }, { 3, 5 } };
        System.out.println("Результат объединения:" + Arrays.deepToString(new Intervals().merge(intervals5)));
    }
}
