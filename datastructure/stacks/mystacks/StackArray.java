package datastructures.stacks.mystacks;

public class StackArray {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 当前栈的最大容量
     */
    private int maxSize;
    /**
     * 存储元素
     */
    private int[] stackArray;
    /**
     * 栈顶
     */
    private int top;

    public StackArray(){
        this(DEFAULT_CAPACITY);
    }

    public StackArray(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    /**
     * 入栈 始终在栈顶操作
     * @param value
     */
    public void push(int value){
        //判断是否已满
        if(!isFull()){
           top++;
           stackArray[top] = value;
        }else {
            //扩容
            resize(maxSize * 2);
            push(value);
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        //判断是否为空
        if(!isEmpty()){
            return stackArray[top--];
        }
        //判断当前容量是否小于最大容量的1/4 缩容一半  节省内存
        if(top < maxSize / 4){
            //缩容
            resize(maxSize / 2);
            return pop();
        }else {
            //栈空
            return -1;
        }
    }

    /**
     * 获得栈顶元素
     * @return
     */
    public int peek(){
        if(!isEmpty()){
            return stackArray[top];
        }else {
            //栈空
            return -1;
        }
    }

    private void resize(int newSize){
        //新数组
        int[] transferArray = new int[newSize];
        //将之前栈中元素拷贝到新数组
        for (int i = 0; i < stackArray.length; i++) {
            transferArray[i] = stackArray[i];
        }
        //覆盖原数组
        stackArray = transferArray;
        maxSize = newSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top + 1 == maxSize;
    }
}
