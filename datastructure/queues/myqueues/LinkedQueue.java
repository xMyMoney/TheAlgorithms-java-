package datastructures.queues.myqueues;

import java.util.NoSuchElementException;

public class LinkedQueue {
    class Node{
        //元素
        int data;
        //下一个Node
        Node next;

        //创建默认链队列
        public Node(){
            this(0);
        }

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 队头
     */
    private Node front;
    /**
     * 队尾
     */
    private Node rear;
    /**
     * 队列长度
     */
    private int size;

    /**
     * 创建一个链队列
     */
    public LinkedQueue(){
        front = rear = new Node();
    }

    /**
     *
     * @return 队列为空返回true
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在队尾插入node
     * @param data 入队的值
     * @return
     */
    public boolean enqueue(int data){
        Node newNode = new Node(data);
        rear.next = newNode;
        //队尾始终指向最后一个node
        rear = newNode;
        size++;
        return true;
    }

    /**
     *删除队头node
     * @return 被删除node的data
     */
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("队列为空！");
        }
        Node destroy = front.next;
        int retValue = destroy.data;
        front.next = front.next.next;
        destroy = null;
        size--;

        if(isEmpty()){
            front = rear;
        }
        return retValue;
    }

    /**
     *
     * @return 返回队头元素
     */
    public int peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return front.next.data;
    }
    /**
     *
     * @return 队尾元素
     */
    public int peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return rear.data;
    }

    /**
     *
     * @return 队列长度
     */
    public int size() {
        return size;
    }

    /**
     * 清空队列
     */
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = front.next;
        builder.append("[");
        while (cur != null) {
            builder.append(cur.data).append(", ");
            cur = cur.next;
        }
        builder.replace(builder.length() - 2, builder.length(), "]");
        return builder.toString();
    }
}
