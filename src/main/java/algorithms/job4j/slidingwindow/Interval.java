package algorithms.job4j.slidingwindow;

import java.util.*;

/**
 * 2 задача.
 *
 * Алгоритм скользящее окно.
 *
 * Дан массив интервалов, где каждый интервал представлен двумя числами
 * `[start, end]`, которые обозначают начало и конец интервала.
 * Требуется найти границы нового интервала, который перекрывает максимальное количество других интервалов.
 *
 * Если событие является началом (isStart равно true), увеличивает счетчик перекрытий (countWindow).
 * Если текущее количество перекрытий больше максимального (maxRanges),
 * обновляет максимальное значение и запоминает время начала.
 * Если событие является концом, проверяет, равно ли текущее количество перекрытий максимальному,
 * и если да, запоминает время конца.
 *
 * Рассмотрим пример с данными, для интервалов `[1, 4]`, `[2, 6]`, `[3, 5]`, `[7, 8]`,
 * новый интервал будет `[3, 4]`, так как он перекрывает три интервала.
 *
 * Временная сложность: O(n log n):
 * = cоздание списка событий требует O(n), cортировка списка событий требует O(n log n),
 * перебор отсортированного списка событий требует O(n).
 *
 * Пространственная сложность: Для хранения списка событий используется O(n)
 *
 */
class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * Данный класс позволяет определить класс объектов событий начала и конца, далее сортировать
 * и работать с массивом событий.
 */
class Event implements Comparable<Event> {
    int time;
    boolean isStart;

    Event(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(Event other) {
        if (this.time == other.time) {
            return this.isStart ? -1 : 1;
        }
        return Integer.compare(this.time, other.time);
    }
}

class Main {

    /**
     * Метод возвращает лист отсортированных событий всех интервалов "начала" и "конца".
     * "начала" - всегда идет в начале. Это достигается методом compareTo(Event other) в классе Event.
     */
    private List<Event> eventList(List<Interval> intervals) {
        List<Event> events = new ArrayList<>();
        for (Interval i : intervals) {
            events.add(new Event(i.start, true));
            events.add(new Event(i.end, false));
        }
        Collections.sort(events);
        return events;
    }

    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        List<Event> events = new Main().eventList(intervals);
        int countWindow = 0;
        int maxRanges = 0;
        int start = -1;
        int end = -1;
        for (Event event : events) {
            if (event.isStart) {
                countWindow++;
                if (countWindow > maxRanges) {
                    maxRanges = countWindow;
                    start = event.time;
                }
            } else {
                if (countWindow == maxRanges) {
                    end = event.time;
                }
                countWindow--;
            }
        }
        return new int[]{start, end};
    }

    /**
     * Второй вариант поиска интервала.
     * Сначала проходим и ищем максимальное чилсло перекрывающихся интервалов и
     * начала максимального перекрытия.
     * Далее повторно проходим. end устанавливается только после того,
     * как найдено максимальное количество перекрытий, и это значение фиксируется только
     * при нахождении первого события конца после начала максимального перекрытия.
     */
    public static int[] findMaxOverlapIntervalVar2(List<Interval> intervals) {
        List<Event> events = new Main().eventList(intervals);
        int count = 0;
        int max = 0;
        int start = -1;
        int end = -1;
        for (Event event : events) {
            count = event.isStart ? count + 1 : count - 1;
            if (count > max) {
                max = count;
                start = event.time;
            }
        }
        if (start != -1) {
            for (Event event : events) {
                if (!event.isStart && start < event.time) {
                    end = event.time;
                    break;
                }
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));

        int[] result = findMaxOverlapInterval(intervals);

        System.out.println("Interval that overlaps the maximum "
                + "number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}
