package org.example;

public class SplayTree<T extends Comparable<T>> {
    private Node root;

    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
        }
    }

    public void insert(T item) {
        root = insert(root, item);
        root = splay(root, item);
    }

    private Node insert(Node node, T item) {
        if (node == null) return new Node(item);

        int cmp = item.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, item);
        } else if (cmp > 0) {
            node.right = insert(node.right, item);
        } else {
            // If the item already exists, update it (optional, depending on requirements)
            node.data = item;
        }

        return node;
    }

    public String get(T item) {
        root = splay(root, item);
        if (root != null && root.data.equals(item)) {
            if (root.data instanceof KeyValuePair) {
                return ((KeyValuePair) root.data).getValue();
            }
        }
        return ""; // Return empty string if the item is not found
    }

    public void delete(T item) {
        root = splay(root, item);
        if (root != null && root.data.equals(item)) {
            if (root.left == null) {
                root = root.right;
            } else {
                Node rightSubtree = root.right;
                root = splay(root.left, item);
                root.right = rightSubtree;
            }
        }
    }

    private Node splay(Node node, T item) {
        if (node == null) return null;

        int cmp = item.compareTo(node.data);

        if (cmp < 0) {
            if (node.left == null) return node;
            if (item.compareTo(node.left.data) < 0) {
                node.left.left = splay(node.left.left, item);
                node = rotateRight(node);
            } else if (item.compareTo(node.left.data) > 0) {
                node.left.right = splay(node.left.right, item);
                if (node.left.right != null) node.left = rotateLeft(node.left);
            }
            return node.left == null ? node : rotateRight(node);
        } else if (cmp > 0) {
            if (node.right == null) return node;
            if (item.compareTo(node.right.data) < 0) {
                node.right.left = splay(node.right.left, item);
                if (node.right.left != null) node.right = rotateRight(node.right);
            } else if (item.compareTo(node.right.data) > 0) {
                node.right.right = splay(node.right.right, item);
                node = rotateLeft(node);
            }
            return node.right == null ? node : rotateLeft(node);
        } else {
            return node;
        }
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }
}
