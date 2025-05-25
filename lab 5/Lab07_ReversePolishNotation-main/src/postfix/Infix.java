package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts an infix expression (as string) to postfix (RPN) using Shunting Yard algorithm.
 */
public class Infix {

    public String toPostfix(String infix) throws Underflow {
        String[] tokens = infix.trim().split("\\s+");
        Stack<String> operatorStack = new LinkedListStack<>();
        List<String> output = new ArrayList<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.top()) >= precedence(token)) {
                    output.add(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.top().equals("(")) {
                    output.add(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.top().equals("(")) {
                    operatorStack.pop(); // remove opening bracket
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            } else {
                throw new IllegalArgumentException("Unknown token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            String op = operatorStack.pop();
            if (op.equals("(") || op.equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(op);
        }

        return String.join(" ", output);
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return "+-*/^".contains(token) && token.length() == 1;
    }

    private int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^"      -> 3;
            default       -> 0;
        };
    }
}
