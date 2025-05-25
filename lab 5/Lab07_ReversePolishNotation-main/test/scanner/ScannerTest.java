package scanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ScannerTest {

    @Test
    public void testSimpleExpression() {
        Scanner scanner = new Scanner("2 + 3");
        String[] expected = {"2", "+", "3"};
        assertArrayEquals(expected, scanner.getToken());
    }

    @Test
    public void testWithParentheses() {
        Scanner scanner = new Scanner("( 2 + 3 ) * 4");
        String[] expected = {"(", "2", "+", "3", ")", "*", "4"};
        assertArrayEquals(expected, scanner.getToken());
    }

    @Test
    public void testMultipleOperators() {
        Scanner scanner = new Scanner("5 + 3 * 2 - 1");
        String[] expected = {"5", "+", "3", "*", "2", "-", "1"};
        assertArrayEquals(expected, scanner.getToken());
    }

    @Test
    public void testDecimalNumbers() {
        Scanner scanner = new Scanner("3.14 + 2.71");
        String[] expected = {"3.14", "+", "2.71"};
        assertArrayEquals(expected, scanner.getToken());
    }

    @Test
    public void testWhitespaceRobustness() {
        Scanner scanner = new Scanner("   7   *    (   2 + 3   )  ");
        String[] expected = {"7", "*", "(", "2", "+", "3", ")"};
        assertArrayEquals(expected, scanner.getToken());
    }
}
