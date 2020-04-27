package datastructures.queues.myqueues;

/**
 * 队列  先进先出  后进后出
 * 比如食堂排队打饭
 */
public class Queue {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 最大容量
     */
    private int maxSize;
    /**
     * 利用数组存储
     */
    private int[] queueArray;
    /**
     * 队头
     */
    private int front;
    /**
     * 队尾
     */
    private int rear;
    /**
     * 当前队列元素个数
     */
    private int nItems;

    /**
     * 创建默认队列
     */
    public Queue(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 使用者自行创建队列
     * @param size
     */
    public Queue(int size){
        maxSize = size;
        queueArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * 在队尾插入一个元素
     * @param x 要添加的元素
     * @return 如果元素添加成功 返回true
     */
    public boolean insert(int x){
        if(isFull()){
           return false;
        }
        //如果rear + 1 == maxSize时,则回到数组下标为0的位置
        rear = (rear + 1) % maxSize;
        queueArray[rear] = x;
        nItems++;
        return true;
    }

    /**
     *在队头删除元素
     * @return 被删除元素
     */
    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int temp = queueArray[front];
        front = (front + 1) % maxSize;
        nItems--;
        return temp;
    }

    /**
     *
     * @return 队头元素
     */
    public int peekFront(){
        return queueArray[front];
    }

    /**
     *
     * @return 队尾元素
     */
    public int peekRear(){
        return queueArray[rear];
    }

    /**
     *
     * @return 队列中元素个数
     */
    public int getSize(){
        return nItems;
    }

    /**
     * 如果数组元素个数为0 则队列为空  返回true
     * @return
     */
    public boolean isEmpty() {
        return nItems == 0;
    }

    /**
     * 如果队列已满 返回true
     * @return
     */
    public boolean isFull(){
        return nItems == maxSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = front; ; i = ++i % maxSize) {
            sb.append(queueArray[i]).append(", ");
            if (i == rear) {
                break;
            }
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
        return sb.toString();
    }
}
