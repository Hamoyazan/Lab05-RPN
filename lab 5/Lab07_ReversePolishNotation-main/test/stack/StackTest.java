package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for LinkedListStack using JUnit 5.
 */
public class StackTest {

	private Stack<String> stack;

	@BeforeEach
	public void setUp() {
		stack = new LinkedListStack<>();
	}

	@Test
	public void testPushOneElement() {
		stack.push("a");
		assertEquals("<stack: a>", stack.toString());
	}

	@Test
	public void testPushMultipleElements() {
		stack.push("a");
		stack.push("b1");
		assertEquals("<stack: a-b1>", stack.toString());
	}

	@Test
	public void testPop() throws Underflow {
		stack.push("a");
		stack.push("b");
		stack.pop();
		assertEquals("<stack: a>", stack.toString());
	}

	@Test
	public void testPop2() throws Underflow {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.pop();
		assertEquals("<stack: a-b>", stack.toString());
	}

	// Axiom 1: isEmpty(new Stack()) = true
	@Test
	public void axiom1() {
		assertTrue(stack.isEmpty());
	}

	// Axiom 2: isEmpty(push(q,x)) = false
	@Test
	public void axiom2() {
		stack.push("A");
		assertFalse(stack.isEmpty());
	}

	// Axiom 3: pop(new Stack()) = error
	@Test
	public void axiom3() {
		assertThrows(Underflow.class, stack::pop);
	}

	// Axiom 4: top(new Stack()) = error
	@Test
	public void axiom4() {
		assertThrows(Underflow.class, stack::top);
	}

	// Axiom 5: pop(push(s,x)) restores stack
	@Test
	public void axiom5OnEmptyStack() throws Underflow {
		String before = stack.toString();
		stack.push("huhu");
		stack.pop();
		assertEquals(before, stack.toString());
	}

	@Test
	public void axiom5OnNonEmptyStack() throws Underflow {
		stack.push("a");
		stack.push("b");
		String before = stack.toString();
		stack.push("huhu");
		stack.pop();
		assertEquals(before, stack.toString());
	}

	// Axiom 6: top(push(s,x)) = x
	@Test
	public void axiom6OnEmptyStack() throws Underflow {
		String x = "huhu";
		stack.push(x);
		assertEquals(x, stack.top());
	}

	@Test
	public void axiom6OnNonEmptyStack() throws Underflow {
		stack.push("a");
		stack.push("b");
		String x = "huhu";
		stack.push(x);
		assertEquals(x, stack.top());
	}
}
