package datastructures.queues;

public class CircleQueue<E> {
    // 记录第0个元素的索引
    private int front;
    // 当前队列存储的元素个数
    private int size;
    // 用来存储元素的数组
    private E[] elements;
    // 设置elements数组默认的初始化空间
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }


    // 当前队列是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    // 入队
    public void enQueue(E element){
        // 数组扩容判断
        ensureCapacity(size + 1);
        // 索引计算，并赋值
        elements[index(size)] = element;
        // size加一
        size++;
    }
    // 出队
    public E deQueue(){
        // 获取出队元素
        E frontElement = elements[front];
        // 将索引位置致空
        elements[front] = null;
        // 更新font
        front = index(1);
        // size减一
        size--;
        // 返回出队元素
        return frontElement;
    }
    // 查看索引为0的元素
   public E front(){
        return elements[front];
   }


    private int index(int index) {
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1); //位运算
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;

        // 重置front
        front = 0;
    }



}
