package Ch09;

import java.util.Comparator;

public class DoubleLinkedList<E> {
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public DoubleLinkedList() {
        head = crnt = new Node<>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> cur = head.next;

        while (cur != head) {
            if (c.compare(obj, cur.data) == 0) {
                crnt = cur;
                return cur.data;
            }
            cur = cur.next;
        }

        return null;
    }

    public void printCurrentNode() {
        if (isEmpty())
            System.out.println("There's no selected node.");
        else
            System.out.println(crnt.data);
    }

    public void dump() {
        Node<E> cur = head.next;

        while (cur != head) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public void dumpReverse() {
        Node<E> cur = head.prev;

        while (cur != head) {
            System.out.println(cur.data);
            cur = cur.prev;
        }
    }

    public boolean next() {
        if (isEmpty() || crnt.next == head)
            return false;

        crnt = crnt.next;

        return true;
    }

    public boolean prev() {
        if (isEmpty() || crnt.prev == head)
            return false;

        crnt = crnt.prev;

        return true;
    }

    public void add(E obj) {
        Node<E> node = new Node<>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }

    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }

    public void removeCurrentNode() {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if (crnt == head)
                crnt = head.next;
        }
    }

    public void remove(Node n) {
        Node<E> cur = head.next;

        while (cur != head) {
            if (cur == n) {
                crnt = n;
                removeCurrentNode();
                break;
            }
            cur = cur.next;
        }
    }

    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }

    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }

    public void clear() {
        while (!isEmpty())
            removeFirst();
    }
}
