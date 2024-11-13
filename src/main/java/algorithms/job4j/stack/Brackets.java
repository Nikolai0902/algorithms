package algorithms.job4j.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * В этом задании вам необходимо проверить строку.
 * Строка должна содержать валидное сочетания скобок.
 * <p>
 * Скобки могут быть: обычные (, фигурные {, квадратные.
 *
 * Этот алгоритм работает за O(n) времени и использует O(n) дополнительной памяти.
 */
public class Brackets {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char str : s.toCharArray()) {
            if (str == '(' || str == '{' || str == '[') {
                stack.push(str);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char pop = stack.pop();
                if ((str == ')' && pop != '(')
                        || (str == '}' && pop != '{')
                        || (str == ']' && pop != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
