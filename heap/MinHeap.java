public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    int[] heap = new int[capacity];

    // Return the first node in the heap.
    public int peek() {
        if (size > 0) {
            return heap[0];
        }

        return 0;
    }

    // Remove the smallest value node from the heap and return it.
    public int poll() {
        if (size > 0) {
            int value = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown();
            return value;
        }

        return 0;
    }

    // Add a node to the heap.
    public void add(int value) {
        resizeHeap();
        heap[size] = value;
        size++;
        heapifyUp();
    }

    public void heapifyDown() {
        int index = 0;

        // While there is at least one child node.
        while (hasLeftChild(index)) {
            int smallerValueIndex = getLeftChildIndex(index);

            if ((hasRightChild(index)) && (getRightChild(index) < getLeftChild(index))) {
                smallerValueIndex = getRightChildIndex(index);
            }

            if (heap[index] < heap[smallerValueIndex]) {
                break;
            } else {
                swap(index, smallerValueIndex);
                index = smallerValueIndex;
            }
        }
    }

    public void heapifyUp() {
        int index = size - 1;

        while ((hasParent(index)) && (getParent(index) > heap[index])) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    // Swap two nodes in the heap.
    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    // Handles resizing of heap if capacity is exceeded.
    private void resizeHeap() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    /* Helper Methods */
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getLeftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private int getParent(int index) {
        return heap[getParentIndex(index)];
    }
}