import postfix.Infix;
import postfix.Postfix;
import scanner.Scanner;
import stack.Underflow;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        Infix infixConverter = new Infix();
        Postfix postfixEvaluator = new Postfix();

        System.out.println("=== Reverse Polish Notation Evaluator ===");
        System.out.println("Type your infix expression with spaces (e.g., ( 2 + 3 ) * 4)");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter expression: ");
            String expression = input.nextLine();

            if (expression.trim().equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            try {
                // Step 1: Tokenizing
                Scanner tokenScanner = new Scanner(expression);
                String[] tokens = tokenScanner.getToken();
                System.out.print("→ Tokens: ");
                for (String token : tokens) {
                    System.out.print(token + " ");
                }
                System.out.println();

                // Step 2: Convert to Postfix
                String postfix = infixConverter.toPostfix(expression);
                System.out.println("→ Postfix: " + postfix);

                // Step 3: Evaluate Postfix
                double result = postfixEvaluator.evaluate(postfix);
                System.out.println("→ Result: " + result);

            } catch (Underflow e) {
                System.out.println("Stack Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        input.close();
    }
}
