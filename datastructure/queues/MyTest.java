package datastructures.queues;

import org.junit.Test;

public class MyTest {
    @Test
    public void test1(){
      Queue<Integer> queue = new Queue<>();
      queue.enQueue(1);
      queue.enQueue(2);
      queue.enQueue(3);
      while (!queue.isEmpty()){
          System.out.println(queue.deQueue());   //先进先出
      }
    }
}
