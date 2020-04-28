package datastructures.lists.mylists;

public class CircleLinkedList<E> {
    /**
     * 节点
     * @param <E>
     */
    private static class Node<E> {
        Node<E> next;
        E value;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    private int size;
    private Node<E> head;

    /**
     * 默认创建
     */
    public CircleLinkedList() {
        //一个虚拟节点
        head = new Node<E>(null, head);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加节点
     * @param value
     */
    public void append(E value) {
        if (value == null) {
            // 不能添加一个空的节点到链表
            throw new NullPointerException("Cannot add null element to the list");
        }
        head.next = new Node<E>(value, head);
        size++;
    }

    /**
     * 按指定位置删除
     * @param pos
     * @return 被删除节点值
     */
    public E remove(int pos) {
        //检测删除位置是否合法
        if (pos > size || pos < 0) {
            throw new IndexOutOfBoundsException("position cannot be greater than size or negative");
        }
        Node<E> before = head;
        //找到删除位置节点的前一个节点
        for (int i = 1; i <= pos; i++) {
            before = before.next;
        }
        Node<E> destroy = before.next;
        E saved = destroy.value;
        before.next = before.next.next;
        destroy = null;
        size--;
        return saved;
    }


}
