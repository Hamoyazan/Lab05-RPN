package stack;

/**
 * Exception thrown when attempting to access or remove an element from an empty stack.
 */
public class Underflow extends Exception {

	private static final long serialVersionUID = 1L;

	public Underflow() {
		super("Stack underflow: cannot access or remove from an empty stack.");
	}

	public Underflow(String message) {
		super(message);
	}
}
