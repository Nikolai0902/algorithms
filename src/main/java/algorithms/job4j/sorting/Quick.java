package algorithms.job4j.sorting;

import java.util.Arrays;

/**
 * Быстрая сортировка для массива.
 * <p>
 * Разбиение Хоара:
 * 1. В качестве опорного элемента выбираем первый элемент последовательности
 * supportElement = sequence[0]
 * 2. Объявляем две переменных для хранения индексов
 * int beginToEnd = sequence[1]
 * int endToBegin = sequence[sequince.lenght-1]
 * 3. Продвигаясь в направлении конца последовательности, производим поиск первого элемента, для которого выполняется условие
 * sequence[beginToEnd] >= supportElement
 * 4. Продвигаясь в направлении начала последовательности, производим поиск первого элемента, для которого выполняется условие
 * sequence[endToBegin] <= supportElement
 * 5. После окончания поисков проверяем условие:
 * beginToEnd >= endToBegin
 * Если условие true, то переходим к пункту 9, если false - переходим к пункту 6.
 * 6. Меняем элементы по индексам beginToEnd и endToBegin между собой местами.
 * 7. Изменяем индексы:
 * beginToEnd++
 * endToBegin--
 * 8. Возвращаемся к шагу 3 и продолжаем выполнение алгоритма.
 * 9. Производим обмен элементов - элемент по индексу beginToEnd располагаем в начале последовательности (вместо supportElement), а
 * supportElement располагаем по индексу beginToEnd.
 * 10. Возвращаем значение индекса beginToEnd
 */
public class Quick {

    public static void quickSort(int[] sequence) {
        quickSort(sequence, 0, sequence.length - 1);
    }

    private static void quickSort(int[] sequence, int start, int end) {
        if (start >= end) {
            return;
        }
        int h = breakPartition(sequence, start, end);
        quickSort(sequence, start, h - 1);
        quickSort(sequence, h + 1, end);
    }

    private static int breakPartition(int[] sequence, int start, int end) {
        int leftIndex = start + 1;
        int supportElement = sequence[start];
        int rightIndex = end;
        while (true) {
            while (leftIndex < end && sequence[leftIndex] < supportElement) {
                leftIndex++;
            }
            while (sequence[rightIndex] > supportElement) {
                rightIndex--;
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            swap(sequence, leftIndex++, rightIndex--);
        }
        swap(sequence, start, rightIndex);
        return rightIndex;
    }

    /**
     * Другой вариант метода breakPartition()
     */
    private static int breakPartitionVatTwo(int[] sequence, int start, int end) {
        int supportElement = sequence[end];
        int beginToEnd = start - 1;
        for (int i = start; i < end; i++) {
            if (sequence[i] < supportElement) {
                beginToEnd++;
                swap(sequence, beginToEnd, i);
            }
        }
        swap(sequence, beginToEnd + 1, end);
        return beginToEnd + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 5, 10, -2, 7, 3, -2};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
