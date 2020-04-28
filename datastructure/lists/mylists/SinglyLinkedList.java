package datastructures.lists.mylists;

public class SinglyLinkedList {

    /**
     * 节点类
     */
    class Node{
        /**
         * 节点的值
         */
        int value;
        /**
         * 指向下一个节点
         */
        Node next;
        Node(){

        }
        Node(int value){
            this(value,null);
        }

        Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头节点
     */
    private Node head;
    /**
     * 链表长度
     */
    private int size;

    /**
     * 创建默认链表
     */
    public SinglyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    /**
     *创建链表
     * @param head
     * @param size
     */
    public SinglyLinkedList(Node head,int size){
        this.head = head;
        this.size = size;
    }

    /**
     * 从头部插入节点
     * @param x
     */
    public void insertHead(int x){
        insertNth(x,0);
    }

    /**
     * 从尾部插入节点
     * @param data
     */
    public void insert(int data){
        insertNth(data,size);
    }

    /**
     * 在指定位置插入节点
     * @param data 新节点的值
     * @param position 在链表中的位置
     */
    public void insertNth(int data,int position){
        checkBounds(position, 0, size);
        Node cur = head;
        //找到插入位置节点的前一个节点 ++i
        for (int i = 0; i < position; ++i) {
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    /**
     * 插入节点，按值排序
     * @param data
     */
    public void insertSorted(int data){
        Node cur = head;
        //找到大于data节点的前一个位置
        while (cur.next != null && data > cur.next.value){
            cur = cur.next;
        }
        Node newNode = new Node(data);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    /**
     * 删除头节点
     */
    public void deleteHead(){
        deleteNth(0);
    }

    /**
     * 删除尾节点
     */
    public void delete(){
        deleteNth(size - 1);
    }

    /**
     * 按指定位置删除节点
     * @param position
     */
    public void deleteNth(int position){
        checkBounds(position, 0, size - 1);
        Node cur = head;
        //找到position位置节点的前一个节点
        for (int i = 0; i < position; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    /**
     * 检测位置是否合法
     * @param position
     * @param low 开始位置
     * @param high  结束位置
     */
    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /**
     * 删除链表中所有节点
     */
    public void clear(){
        if(size == 0){
            return;
        }
        Node prev = head.next;
        Node cur = prev.next;
        while (cur != null){
            prev = null;
            prev = cur;
            cur = cur.next;
        }
        prev = null;
        head.next = null;
        size = 0;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 返回链表长度
     * @return
     */
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = head.next;
        while (cur != null) {
            builder.append(cur.value).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length() - 2, builder.length(), "").toString();
    }

    /**
     * 合并两个排序链表 (本来是static修饰的  但是不知道为什么new head报错)
     * @param listA
     * @param listB
     * @return
     */
    public SinglyLinkedList merge(SinglyLinkedList listA, SinglyLinkedList listB) {
        Node headA = listA.head.next;
        Node headB = listB.head.next;

        int size = listA.size() + listB.size();

        Node head = new Node();
        Node tail = head;
        while (headA != null && headB != null) {
            if (headA.value <= headB.value) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }
        if (headA == null) {
            tail.next = headB;
        }
        if (headB == null) {
            tail.next = headA;
        }
        return new SinglyLinkedList(head, size);
    }
}
