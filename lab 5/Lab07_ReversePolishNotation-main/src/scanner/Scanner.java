package scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Tokenizes an infix expression string into an array of tokens (numbers, operators, parentheses).
 */
public class Scanner {

    private final String input;

    public Scanner(String input) {
        this.input = input;
    }

    public String[] getToken() {
        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                continue; // Skip spaces
            }

            if (Character.isDigit(c) || c == '.') {
                number.append(c); // Build multi-digit numbers or decimals
            } else {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }

                if ("+-*/^()".indexOf(c) != -1) {
                    tokens.add(String.valueOf(c));
                } else {
                    throw new IllegalArgumentException("Invalid character: " + c);
                }
            }
        }

        if (number.length() > 0) {
            tokens.add(number.toString());
        }

        return tokens.toArray(new String[0]);
    }
}
