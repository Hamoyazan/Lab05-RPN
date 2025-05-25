package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

/**
 * Evaluates a postfix (Reverse Polish Notation) expression.
 */
public class Postfix {

	public double evaluate(String postfix) throws Underflow {
		String[] tokens = postfix.trim().split("\\s+");
		Stack<Double> stack = new LinkedListStack<>();

		for (String token : tokens) {
			if (isNumber(token)) {
				stack.push(Double.parseDouble(token));
			} else if (isOperator(token)) {
				if (stack.isEmpty()) throw new Underflow("Missing operand");
				double b = stack.pop();
				if (stack.isEmpty()) throw new Underflow("Missing operand");
				double a = stack.pop();
				stack.push(applyOperator(a, b, token));
			} else {
				throw new IllegalArgumentException("Invalid token: " + token);
			}
		}

		if (stack.isEmpty()) throw new Underflow("No result");
		double result = stack.pop();
		if (!stack.isEmpty()) throw new IllegalStateException("Too many operands");
		return result;
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

	private double applyOperator(double a, double b, String op) {
		return switch (op) {
			case "+" -> a + b;
			case "-" -> a - b;
			case "*" -> a * b;
			case "/" -> a / b;
			case "^" -> Math.pow(a, b);
			default -> throw new IllegalArgumentException("Unknown operator: " + op);
		};
	}
}
