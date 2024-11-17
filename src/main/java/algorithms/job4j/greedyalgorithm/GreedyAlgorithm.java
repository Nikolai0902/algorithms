package algorithms.job4j.greedyalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1 задача.
 *
 * Жадный алгоритм. Суть такова, что нужно на каждом шаге выбирать
 * наиболее оптимальное решение.“Оптимальное” решение — то,
 * которое предлагает наиболее очевидную
 * и немедленную выгоду на определенном шаге/этапе.
 *
 * Необходимо вычислить минимальное количество монет для сдачи.
 * У нас есть монеты номиналом 1, 5, 10, 25 и 50 центов.
 * Мы начинаем с самой крупной монеты и продолжаем добавлять её,
 * пока это возможно, затем переходим к следующей.
 */
public class GreedyAlgorithm {
    public static List<Integer> getChange(int amount) {
        int[] coins = {50, 25, 10, 5, 1};
        List<Integer> result = new ArrayList<>();

        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int amount = 93;
        List<Integer> change = getChange(amount);
        System.out.println("Сдача для " + amount + " : " + change);
    }
}
