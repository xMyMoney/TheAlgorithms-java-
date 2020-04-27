package datastructures.queues.myqueues;

import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){
        Queue myQueue = new Queue(4);
        myQueue.insert(10);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(3);
        // [10(front), 2, 5, 3(rear)]
        // Will print true
        System.out.println(myQueue.isFull());

        myQueue.remove(); // Will make 2 the new front, making 10 no longer part of the queue
        // [10, 2(front), 5, 3(rear)]
        // Insert 7 at the rear which will be index 0 because of wrap around
        myQueue.insert(7);
        // [7(rear), 2(front), 5, 3]
        // Will print 2
        System.out.println(myQueue.peekFront());
        // Will print 7
        System.out.println(myQueue.peekRear());
        // Will print [2, 5, 3, 7]
        System.out.println(myQueue.toString());
    }

    @Test
    public void test2(){
        LinkedQueue queue = new LinkedQueue();
        assert queue.isEmpty();
        /* 1 */
        queue.enqueue(1);
        /* 1 2 */
        queue.enqueue(2);
        /* 1 2 3 */
        queue.enqueue(3);
        /* [1, 2, 3] */
        System.out.println(queue);

        assert queue.size() == 3;
        assert queue.dequeue() == 1;
        assert queue.peekFront() == 2;
        assert queue.peekRear() == 3;

        queue.clear();
        assert queue.isEmpty();
        /* [] */
        System.out.println(queue);
    }

    @Test
    public void test3(){
        PriorityQueue myQueue = new PriorityQueue(4);
        myQueue.insert(10);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(3);
        // [2, 3, 5, 10] Here higher numbers have higher priority, so they are on the top

//        for (int i = 3; i >= 0; i--){
//            // will print the queue in reverse order [10, 5, 3, 2]
//            System.out.print(myQueue.remove() + " ");
//        }
        while (!myQueue.isEmpty()){
            System.out.print(myQueue.remove() + " ");
        }


        // As you can see, a Priority Queue can be used as a sorting algotithm
    }
}
