public class LinkedList {
    Node head;

    private static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add a new node to the end of the linked list.
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(data);
    }

    // Add a new node to the beginning of the linked list.
    public void prepend(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    // Delete the node in the linked list with the given value.
    public void delete(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node cur = head;
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
    public boolean contains(int data) {
        if (head == null)
            return false;

        Node cur = head;
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

        Node cur = head;
        int count = 0;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}