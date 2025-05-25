package stack;

/**
 * A generic stack interface.
 *
 * @param <E> the type of elements in the stack
 */
public interface Stack<E> {

	/**
	 * Checks if the stack is empty.
	 * @return true if the stack contains no elements, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns the top element of the stack without removing it.
	 * @return the top element
	 * @throws Underflow if the stack is empty
	 */
	E top() throws Underflow;

	/**
	 * Pushes an element onto the top of the stack.
	 * @param element the element to add
	 */
	void push(E element);

	/**
	 * Removes and returns the top element of the stack.
	 * @return the removed element
	 * @throws Underflow if the stack is empty
	 */
	E pop() throws Underflow;
}
