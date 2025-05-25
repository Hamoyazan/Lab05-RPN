package postfix;

import org.junit.jupiter.api.Test;
import stack.Underflow;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Infix2PostfixTest {

    Infix infixConverter = new Infix();

    @Test
    public void testSimpleAddition() throws Underflow {
        String infix = "2 + 3";
        String expectedPostfix = "2 3 +";
        assertEquals(expectedPostfix, infixConverter.toPostfix(infix));
    }

    @Test
    public void testWithMultiplication() throws Underflow {
        String infix = "2 + 3 * 4";
        String expectedPostfix = "2 3 4 * +";
        assertEquals(expectedPostfix, infixConverter.toPostfix(infix));
    }

    @Test
    public void testWithParentheses() throws Underflow {
        String infix = "( 2 + 3 ) * 4";
        String expectedPostfix = "2 3 + 4 *";
        assertEquals(expectedPostfix, infixConverter.toPostfix(infix));
    }

    @Test
    public void testComplexExpression() throws Underflow {
        String infix = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
        String expectedPostfix = "3 4 2 * 1 5 - 2 3 ^ ^ / +";
        assertEquals(expectedPostfix, infixConverter.toPostfix(infix));
    }
}
