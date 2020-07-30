public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Returns true if the queue is empty; otherwise, returns false.
    public boolean isEmpty() {
        return head == null;
    }

    // Look at the first element in the queue and return it.
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return head.data;
    }

    // Add a new node to the end of the queue.
    public void enqueue(T data) {
        Node<T> node = new Node<T>(data);

        if (tail != null) {
            tail.next = node;
        }
        tail = node;

        if (isEmpty()) {
            head = node;
        }
    }

    // Remove the first node in the queue and returns its data.
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = head.data;
        head = head.next;

        if (isEmpty()) {
            tail = null;
        }

        return data;
    }
}