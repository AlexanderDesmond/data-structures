public class LinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add a new node to the end of the linked list.
    public void append(T data) {
        if (isEmpty()) {
            head = new Node<T>(data);
            return;
        }

        Node<T> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node<T>(data);
    }

    // Add a new node to the beginning of the linked list.
    public void prepend(T data) {
        Node<T> node = new Node<T>(data);
        node.next = head;
        head = node;
    }

    // Delete the node in the linked list with the given value.
    public void delete(T data) {
        if (isEmpty())
            return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node<T> cur = head;
        while (cur.next != null) {
            if (cur.next.data == data) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    // Returns true if the linked list contains the given data; otherwise, returns
    // false.
    public boolean contains(T data) {
        if (isEmpty())
            return false;

        Node<T> cur = head;
        while (cur.next != null) {
            if (cur.next.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // Returns the number of nodes in the linked list.
    public int size() {
        if (head == null)
            return 0;

        Node<T> cur = head;
        int count = 1;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }
}