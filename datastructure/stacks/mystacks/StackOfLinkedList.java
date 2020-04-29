package datastructures.stacks.mystacks;

import java.util.NoSuchElementException;

/**
 * 使用链表实现栈
 */
public class StackOfLinkedList {

    /**
     * 众所周知 链表需要节点
     */
    class Node{
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 栈顶
     */
    Node head;

    /**
     * 栈的长度（大小）
     */
    private int size;

    /**
     * 创建栈
     */
    public StackOfLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 入栈
     * @return
     */
    public boolean push(int x){
        //至于为什么不用判断栈满：使用链表实现 每一个入栈元素都是动态分配节点空间
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack. Nothing to pop");
        }
        Node destroy = head;
        head = head.next;
        int retValue = destroy.data;
        destroy = null;
        size--;
        return retValue;
    }

    /**
     * 获得栈顶元素
     * @return
     */
    public int peek() {
        if (isEmpty()) {
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
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获得栈长度
     * @return
     */
    public int getSize() {
        return size;
    }
}
