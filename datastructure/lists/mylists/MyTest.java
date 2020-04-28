package datastructures.lists.mylists;

import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){
        SinglyLinkedList myList = new SinglyLinkedList();
        assert myList.isEmpty();
        assert myList.toString().equals("");

        myList.insertHead(5);
        myList.insertHead(7);
        myList.insertHead(10);
        assert myList.toString().equals("10->7->5");

        myList.deleteHead();
        assert myList.toString().equals("7->5");

        myList.insertNth(11, 2);
        assert myList.toString().equals("7->5->11");

        myList.deleteNth(1);
        assert myList.toString().equals("7->11");

        myList.clear();
        assert myList.isEmpty();

        /* Test MergeTwoSortedLinkedList
        SinglyLinkedList listA = new SinglyLinkedList();
        SinglyLinkedList listB = new SinglyLinkedList();

        for (int i = 10; i >= 2; i -= 2) {
            listA.insertSorted(i);
            listB.insertSorted(i - 1);
        }
        assert listA.toString().equals("2->4->6->8->10");
        assert listB.toString().equals("1->3->5->7->9");
        assert SinglyLinkedList.merge(listA, listB).toString().equals("1->2->3->4->5->6->7->8->9->10");*/
    }
}
