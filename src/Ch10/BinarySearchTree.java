package Ch10;

import java.util.Comparator;

public class BinarySearchTree<K, V> {
    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void print() {
            System.out.println(value);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;
    private final int MAX = 100;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    public V search(K key) {
        Node<K, V> cur = root;

        while (true) {
            if (cur == null)
                return null;

            int condition = comp(key, cur.getKey());
            if (condition == 0)
                return cur.getValue();
            else if (condition < 0)
                cur = cur.left;
            else
                cur = cur.right;
        }
    }

    private void addNode(Node<K, V> node, K key, V value) {
        int cond = comp(key, node.getKey());
        if (cond == 0)
            return;
        else if (cond < 0) {
            if (node.left == null)
                node.left = new Node<>(key, value, null, null);
            else
                addNode(node.left, key, value);
        } else {
            if (node.right == null)
                node.right = new Node<>(key, value, null, null);
            else
                addNode(node.right, key, value);
        }
    }

    public void add(K key, V value) {
        if (root == null)
            root = new Node<>(key, value, null, null);
        else
            addNode(root, key, value);
    }

    public boolean remove(K key) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if (p == null)
                return false;
            int cond = comp(key, p.getKey());
            if (cond == 0)
                break;
            else {
                parent = p;
                if (cond < 0) {
                    isLeftChild = true;
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        if (p.left == null) {
            if (p == root)
                root = p.right;
            else if (isLeftChild) {
                assert parent != null;
                parent.left = p.right;
            }
            else
                parent.right = p.right;
        } else if (p.right == null) {
            if (p == root)
                root = p.left;
            else if (isLeftChild) {
                assert parent != null;
                parent.left = p.left;
            }
            else
                parent.right = p.left;
        } else {
            parent = p;
            Node<K, V> max = p.left;
            isLeftChild = true;
            while (max.right != null) {
                parent = max;
                max = max.right;
                isLeftChild = false;
            }
            p.key = max.key;
            p.value = max.value;
            if (isLeftChild)
                parent.left = max.left;
            else
                parent.right = max.left;
        }

        return true;
    }

    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " " + node.value);
            printSubTree(node.right);
        }
    }

    public void print() {
        printSubTree(root);
    }

    public void printReverse() {
        Node<K, V> node = root;
        Node[] stack = new Node[MAX];
        int idx = 0;

        while (true) {
            if (node != null) {
                stack[idx++] = node;
                node = node.right;
                continue;
            }
            if (idx > 0) {
                node = stack[--idx];
                System.out.println(node.key + " " + node.value);
                node = node.left;
                continue;
            }
            break;
        }
    }

    public K getMinKey() {
        Node<K, V> cur = root;

        while (cur.left != null)
            cur = cur.left;

        return cur.key;
    }

    public V getValueWithMinKey() {
        K key = getMinKey();

        return search(key);
    }

    public K getMaxKey() {
        Node<K, V> cur = root;

        while (cur.right != null)
            cur = cur.right;

        return cur.key;
    }

    public V getValueWithMaxKey() {
        K key = getMaxKey();

        return search(key);
    }
}
