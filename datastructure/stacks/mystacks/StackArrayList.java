package datastructures.stacks.mystacks;

import java.util.ArrayList;

/**
 * 通过ArrayList集合实现栈
 */
public class StackArrayList {

    private ArrayList<Integer> stackList;

    public StackArrayList() {
        stackList = new ArrayList<>();
    }

    public void push(int value) {
        stackList.add(value);
    }

    public int pop() {
        //判空
        if (!isEmpty()) {
            //stackList.size() - 1  即得到list中最后一个元素 为栈顶元素
            int popValue = stackList.get(stackList.size() - 1);
            //删除
            stackList.remove(stackList.size() - 1);
            return popValue;
        }

        System.out.print("The stack is already empty!");
        return -1;
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int peek() {
        return stackList.get(stackList.size() - 1);
    }
}
