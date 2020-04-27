package datastructures.queues.myqueues;

/**
 * 优先队列  根据优先级元素添加到位置
 * 重要元素在队头
 * 比如最大的数放最前面
 */
public class PriorityQueue {
    /**
     * 最大容量
     */
    private int maxSize;
    /**
     * 利用数组存储
     */
    private int[] queueArray;
    /**
     * 当前队列元素个数
     */
    private int nItems;

    /**
     *
     * @param size 创建队列时指定队列长度
     */
    public PriorityQueue(int size) {
        maxSize = size;
        queueArray = new int[size];
        nItems = 0;
    }

    /**
     * 向插入队列中插入元素
     * @param value
     */
    public void insert(int value){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }else {
            //最后一个元素的位置
            int j =nItems - 1;
            while (j >= 0 && queueArray[j] > value){
                //向后移动位置 直到当插入的值大于队列中的值
                queueArray[j + 1] = queueArray[j];
                j--;
            }
            //找到正确位置后 插入
            queueArray[j + 1] = value;
            nItems++;
        }
    }

    /**
     * 删除队头元素
     * @return 出队元素
     */
    public int remove() {
        return queueArray[--nItems];
    }

    /**
     *
     * @return 队头元素
     */
    public int peek() {
        return queueArray[nItems - 1];
    }

    /**
     *
     * @return 队列元素个数
     */
    public int getSize(){
        return nItems;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull() {
        return (nItems == maxSize);
    }
}
