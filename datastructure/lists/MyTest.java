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
        List<Integer> list = new LinkedList<>();
        show(list);
    }

    @Test
    public void test3(){
        List<Integer> list = new LinkedList2<>();
        show(list);
    }

    private void show(List list){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.toString());
        System.out.println("/***************************");
        list.remove(2);
        System.out.println(list.toString());
        System.out.println("/****************************");
        list.set(2,55);
        System.out.println(list.toString());
        System.out.println("/****************************");
        System.out.println(list.indexOf(5));
    }
}
