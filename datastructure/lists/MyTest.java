package datastructure.lists;

import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){
        List<Integer> list =new ArrayList<>();
        show(list);
    }

    @Test
    public void test2(){
        List<Integer> list = new SingleLinkedList<>();
        show(list);
    }

    @Test
    public void test3(){
        List<Integer> list = new SingleLinkedList2<>();
        show(list);
    }

    @Test
    public void test4(){
        List<Integer> list = new LinkedList<>();
        show(list);
    }

    @Test
    public void test5(){
        List<Integer> list = new SingleCircleLinkedList<>();
        show(list);
    }

    @Test
    public void test6(){
        List<Integer> list = new CircleLinkedList<>();
        show(list);
    }

    private void show(List list){
        //增删改查
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.toString());
        list.add(0,99);
        list.add(list.size(),88);
        System.out.println(list.toString());
        System.out.println("/***************************");
        list.remove(0);
        list.remove(list.size() - 1);
        list.remove(3);
        System.out.println(list.toString());
        System.out.println("/****************************");
        list.set(2,55);
        System.out.println(list.toString());
        System.out.println("/****************************");
        System.out.println("55下标:"+list.indexOf(55));
        System.out.println("下标:"+list.indexOf(55)+" 值为:"+list.get(list.indexOf(55)));
        System.out.println("/****************************");
    }
}
