package postfix;

import org.junit.jupiter.api.Test;
import stack.Underflow;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostfixEvaluationTest {

    private final Postfix postfix = new Postfix();

    @Test
    public void testSimpleAddition() throws Underflow {
        assertEquals(5.0, postfix.evaluate("2 3 +"), 0.0001);
    }

    @Test
    public void testAdditionAndMultiplication() throws Underflow {
        assertEquals(14.0, postfix.evaluate("2 3 4 * +"), 0.0001);
    }

    @Test
    public void testWithDivision() throws Underflow {
        assertEquals(4.0, postfix.evaluate("12 3 /"), 0.0001);
    }

    @Test
    public void testWithExponentiation() throws Underflow {
        assertEquals(81.0, postfix.evaluate("3 4 ^"), 0.0001);
    }

    @Test
    public void testComplexExpression() throws Underflow {
        assertEquals(3.0001220703125, postfix.evaluate("3 4 2 * 1 5 - 2 3 ^ ^ / +"), 0.0001);
    }

    @Test
    public void testNegativeResult() throws Underflow {
        assertEquals(-1.0, postfix.evaluate("2 3 -"), 0.0001);
    }
}
