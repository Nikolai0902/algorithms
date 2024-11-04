package algorithms.job4j.TwoPointers;

/**
 * Для нахождения непрерывного подмассива в массиве, сумма которого равна заданному числу,
 * можно использовать алгоритм двух указателей
 * (two-pointer algorithm).
 */
public class SumMax {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7, 9, 10, 11};
        int sum = 19;

        int left = 0; // левый указатель
        int right = 0; // правый указатель
        int currentSum = 0;

        while (right < arr.length) {

            //добавляем элементы
            currentSum += arr[right];

            //убираем элементы
            while (currentSum > sum && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            if (currentSum == sum) {
                System.out.println("Найден подмассив: [" + left + ", " + right + "]");
                return;
            }
            right++;
        }

        System.out.println("Подмассив не найден");
    }
}
