package topic.queues;

import java.util.Stack;

/**
 * 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 准备2个栈: inStack. outStack
 * 入队时，push到inStack中
 * 出队时
 * 如果outStack为空,将inStack所有元素逐- -弹出， push到outStack, outStack弹出栈顶元素
 * 如果outStack不为空，outStack弹出栈顶元素
 */
public class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** 入队 */
    public void push(int x) {
        inStack.push(x);
    }

    /** 出队 */
    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    /** 获取队头元素 */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /** 是否为空 */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
