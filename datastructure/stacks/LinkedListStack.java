package datastructures.stacks;

import java.util.NoSuchElementException;

public class LinkedListStack<E> {

    Node head;
    private int size;
    private class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListStack() {
        head = null;
        size = 0;
    }

    /**
     * Add element at top
     *
     * @param x to be added
     * @return <tt>true</tt> if add successfully
     */
    public boolean push(E x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    /**
     * Pop element at top of stack
     *
     * @return element at top of stack
     * @throws NoSuchElementException if stack is empty
     */
    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException("Empty stack. Nothing to pop");
        }
        Node destroy = head;
        head = head.next;
        E retValue = destroy.data;
        destroy = null; // clear to let GC do it's work
        size--;
        return retValue;
    }

    /**
     * Peek element at top of stack
     *
     * @return element at top of stack
     * @throws NoSuchElementException if stack is empty
     */
    public E peek() {
        if (size == 0) {
            throw new NoSuchElementException("Empty stack. Nothing to pop");
        }
        return head.data;
    }

    @Override
    public String toString() {
        Node cur = head;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.data).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length() - 2, builder.length(), "").toString();
    }

    /**
     * Check if stack is empty
     *
     * @return <tt>true</tt> if stack is empty, otherwise <tt>false</tt>
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return size of stack
     *
     * @return size of stack
     */
    public int getSize() {
        return size;
    }

}
