@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
    private T[] arr;
    private int len = 0; // Length of array used by user.
    private int capacity = 0; // Actual size of array

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    // Return the array's 'length' (how many items are currently in the array).
    public int size() {
        return len;
    }

    // Return true if the array is empty; otherwise, return false.
    public boolean isEmpty() {
        return size() == 0;
    }

    // Get the value of the element at the given index.
    public T get(int index) {
        return arr[index];
    }

    // Set the value at the given index to the given element.
    public void set(int index, T elem) {
        arr[index] = elem;
    }

    // Clear the array by setting all values to null and resetting the length to 0.
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    // Add a new element to the array.
    public void add(T elem) {
        // Resize array
        if (len + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }

            // Create new array.
            T[] newArr = (T[]) new Object[capacity];

            // Copy elements into the new array.
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }

            // New array becomes main array.
            arr = newArr;
        }

        // Add new element into the array.
        arr[len++] = elem;
    }

    // Removes an element at the given index and returns its value.
    public T removeAt(int index) {
        if (index >= len && index < 0)
            throw new IndexOutOfBoundsException();

        // Get the data from the element at the given index and create a new array.
        T data = arr[index];
        T[] newArr = (T[]) new Object[len - 1];

        // Copy elements into the new array, except for the removed element.
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == index) {
                j--;
            } else {
                newArr[j] = arr[i];
            }
        }

        // New array becomes main array and capacity and length are adjusted.
        arr = newArr;
        capacity = --len;

        // Return the value of the removed element.
        return data;
    }

    // Remove an object from the array. If successful return true; otherwise, return
    // false.
    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    // Returns the index of the given object from the array if it exists; otherwise,
    // returns -1.
    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                return i;
            }
        }

        return -1;
    }

    // Returns true if the object exists in the array; otherwise, returns false.
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    // Override hasNext() and next() methods.
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public T next() {
                return arr[index++];
            }
        };
    }

    // Override toString() to get a string representation of the array.
    @Override
    public String toString() {
        if (len == 0) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder(len).append("[");

            for (int i = 0; i < len - 1; i++) {
                stringBuilder.append(arr[i] + ", ");
            }

            return stringBuilder.append(arr[len - 1] + "]").toString();
        }
    }
}