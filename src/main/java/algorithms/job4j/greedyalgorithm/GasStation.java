package algorithms.job4j.greedyalgorithm;

/**
 * 3 задача
 * <p>
 * Жадный алгоритм.
 * <p>
 * Есть `n` заправочных станций, расположенных по круговому маршруту.
 * У каждой станции есть количество бензина `gas[i]`, и стоимость бензина для перемещения
 * к следующей станции `cost[i]`. Необходимо определить, с какой станции можно начать движение,
 * чтобы проехать весь круг и вернуться на ту же станцию. Если такой станции нет, вернуть -1.
 * Жадный алгоритм (greedy algorithm) используется
 * в данной задаче для определения стартовой станции
 * <p>
 * В данной задаче жадный алгоритм помогает эффективно и правильно выбрать стартовую станцию,
 * основываясь на локальных оптимальных решениях и глобальной проверке.
 * <p>
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * <p>
 * Временная сложность: O(n); Пространственная сложность: O(1).
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return totalGas >= totalCost ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        new GasStation().canCompleteCircuit(gas, cost);
    }
}
