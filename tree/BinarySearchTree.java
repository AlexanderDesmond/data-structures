public class BinarySearchTree {

    private Node root;

    private static class Node {
        private int data;
        private Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Insert a new node then return it.
        private Node insert(Node current, int value) {
            // If the current node is null, create it and then return it.
            if (current == null) {
                return new Node(value);
            }

            // If the given value is less then the current node's value, go to the left
            // If the given value is greater then the current node's value, go to the right
            if (value < current.data) {
                current.left = insert(current.left, value);
            } else if (value > current.data) {
                current.right = insert(current.right, value);
            } else {
                return current;
            }

            return current;
        }

        // If a node with the given value exists in the tree return true; otherwise,
        // return false.
        private boolean find(Node current, int value) {
            // Return false if the value cannot be found.
            if (current == null) {
                return false;
            }
            // Return true if the value is found.
            if (value == current.data) {
                return true;
            }

            if (value < current.data) {
                return find(current.left, value);
            } else {
                return find(current.right, value);
            }
        }

        // Delete the node with the given value then return it.
        private Node delete(Node current, int value) {
            // If the node doesn't exist return null.
            if (current == null) {
                return null;
            }

            // If the node is found, handle the deletion of the current node.
            if (value == current.data) {
                // If it is a leaf node (i.e. no children)
                if (current.left == null && current.right == null) {
                    return null;
                }

                // If the node only has a single child node.
                if (current.right == null) {
                    return current.left;
                }
                if (current.left == null) {
                    return current.right;
                }

                // If the node has two child nodes.
                int smallerValue = getSmallerValue(current.right);
                current.data = smallerValue;
                current.right = delete(current.right, smallerValue);
                return current;
            }

            if (value < current.data) {
                current.left = delete(current.left, value);
                return current;
            } else {
                current.right = delete(current.right, value);
                return current;
            }
        }

        // Get the smaller value
        private int getSmallerValue(Node root) {
            return root.left == null ? root.data : getSmallerValue(root.left);
        }
    }

    // Add a new node to the tree.
    public void add(int value) {
        if (root != null) {
            root = root.insert(root, value);
        } else {
            root = new Node(value);
        }
    }

    // Find the node with the given value.
    public boolean find(int value) {
        return root.find(root, value);
    }

    // Delete a node with the given value.
    public void delete(int value) {
        root = root.delete(root, value);
    }

    // Pre-Order Traversal
    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(" " + node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    // In-Order Traversal
    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(" " + node.data);
            inOrderTraversal(node.right);
        }
    }

    // Post-Order Traversal
    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(" " + node.data);
        }
    }
}