package datastructures.stacks.mystacks;

import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){
        // Declare a stack of maximum size 4
        StackArray myStackArray = new StackArray(4);

        // Populate the stack
        myStackArray.push(5);
        myStackArray.push(8);
        myStackArray.push(2);
        myStackArray.push(9);

        System.out.println("*********************Stack Array Implementation*********************");
        System.out.println(myStackArray.isEmpty()); // will print false
        System.out.println(myStackArray.isFull()); // will print true
        System.out.println(myStackArray.peek()); // will print 9
        System.out.println(myStackArray.pop()); // will print 9
        System.out.println(myStackArray.peek()); // will print 2
    }

    @Test
    public void test2(){
        StackArrayList myStackArrayList = new StackArrayList();

        myStackArrayList.push(5);
        myStackArrayList.push(8);
        myStackArrayList.push(2);
        myStackArrayList.push(9);

        System.out.println("*********************Stack List Implementation*********************");
        // will print false
        System.out.println(myStackArrayList.isEmpty());
        // will print 9
        System.out.println(myStackArrayList.peek());
        // will print 9
        System.out.println(myStackArrayList.pop());
        // will print 2
        System.out.println(myStackArrayList.peek());
        // will print 2
        System.out.println(myStackArrayList.pop());
    }

    @Test
    public void test3(){
        StackOfLinkedList stack = new StackOfLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        System.out.println("Size of stack currently is: " + stack.getSize());

        assert stack.pop() == 5;
        assert stack.pop() == 4;

        System.out.println("Top element of stack currently is: " + stack.peek());
    }
}
