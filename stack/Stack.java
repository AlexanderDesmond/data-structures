public class Stack<T> {
    private Node<T> top;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Return true if the stack is empty; otherwise, return false.
    public boolean isEmpty() {
        return top == null;
    }

    // Look at the top element of the stack and return it.
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return top.data;
    }

    // Adds a new node to the top of the stack.
    public void push(T data) {
        Node<T> node = new Node<T>(data);
        node.next = top;
        top = node;
    }

    // Remove the top element from the stack and return its data.
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T data = top.data;
        top = top.next;
        return data;
    }
}