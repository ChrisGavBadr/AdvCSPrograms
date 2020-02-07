package classwork.cw8;

import java.util.*;

public class PostfixEvaluate {

    public static void main(String[] args) {
        Queue<String> expressions = new LinkedList<>(Arrays.asList("1 2 3 * + 4 +", "2 3 1 * + 9 -", "3 4 /"));

        while (!expressions.isEmpty()) {
            String pfexpr = expressions.remove();
            System.out.println(pfexpr + " = " + postfixEvaluate(pfexpr));
        }
    }

    public static double postfixEvaluate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Double> numbers = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "*":
                    numbers.push(numbers.pop() * numbers.pop());
                    break;
                case "/":
                    numbers.push(1 / (double) numbers.pop() * numbers.pop());
                    break;
                case "+":
                    numbers.push(numbers.pop() + numbers.pop());
                    break;
                case "-":
                    numbers.push(-numbers.pop() + numbers.pop());
                    break;
                default:
                    numbers.push(Double.parseDouble(token));
            }
        }

        return numbers.pop();
    }
}
