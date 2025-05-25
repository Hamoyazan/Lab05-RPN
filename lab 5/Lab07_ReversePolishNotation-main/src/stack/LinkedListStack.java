package stack;

/**
 * Stack implementation using a singly linked list.
 */
public class LinkedListStack<E> implements Stack<E> {

	// Node class representing each element in the stack
	private class Node<T> {
		T data;
		Node<T> next;

		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * Recursively builds the stack string representation from bottom to top.
		 */
		@Override
		public String toString() {
			return (next == null ? "" : next.toString() + "-") + data.toString();
		}
	}

	private Node<E> top;

	/**
	 * Checks if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Returns the top element without removing it.
	 */
	@Override
	public E top() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Stack is empty");
		}
		return top.data;
	}

	/**
	 * Pushes an element onto the top of the stack.
	 */
	@Override
	public void push(E element) {
		top = new Node<>(element, top);
	}

	/**
	 * Removes and returns the top element of the stack.
	 */
	@Override
	public E pop() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Stack is empty");
		}
		E element = top.data;
		top = top.next;
		return element;
	}

	/**
	 * Returns a string representation of the stack.
	 */
	@Override
	public String toString() {
		if (top == null)
			return "<empty>";
		return "<stack: " + top.toString() + ">";
	}
}
