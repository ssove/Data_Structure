package Ch09;

import java.util.Comparator;

public class LinkedList<E> {
    static class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;
    private Node<E> tail;
    private int length;

    public LinkedList() {
        head = crnt = tail = null;
        length = 0;
    }

    public E search(E key, Comparator<? super E> c) {
        Node<E> cur = head;

        while (cur != tail.next) {
            if (c.compare(key, cur.data) == 0) {
                crnt = cur;
                return cur.data;
            }
            cur = cur.next;
        }

        return null;
    }

    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<>(obj, ptr);
        length++;
    }

    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else
            tail.next = crnt = new Node<>(obj, null);
        length++;
    }

    public void removeFirst() {
        if (head != null)
            head = crnt = head.next;
        length--;
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null)
                removeFirst();
            else {
                Node<E> cur = head;

                while (cur.next != tail)
                    cur = cur.next;

                tail = crnt = cur;
                cur.next = null;
            }
            length--;
        }
    }

    public void remove(Node<E> n) {
        if (head != null) {
            if (head.next == null)
                removeFirst();
            else {
                Node<E> cur = head;

                while (cur.next != n) {
                    cur = cur.next;
                    if (cur == tail.next)
                        return;
                }
                cur.next = n.next;
                crnt = cur;
            }
            length--;
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while (head != null)
            removeFirst();
        crnt = null;
        length = 0;
    }

    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false;

        crnt = crnt.next;

        return true;
    }

    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("There's no selected node.");
        else
            System.out.println(crnt.data);
    }

    public void dump() {
        Node<E> ptr = head;

        while (ptr != tail.next) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    public E retrieve(int n) {
        if (n < 0 || n >= length)
            return null;

        Node<E> cur = head;
        while (n > 0) {
            cur = cur.next;
            n--;
        }

        return cur.data;
    }
}
