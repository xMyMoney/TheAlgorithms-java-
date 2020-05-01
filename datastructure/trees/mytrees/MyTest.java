package datastructures.trees.mytrees;

import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        tree.put(3);
        tree.put(1);
        tree.put(4);
        tree.put(9);
        tree.put(6);
        tree.put(16);
        tree.preOrder(tree.find(5));
        System.out.println();
        tree.inOrder(tree.find(5));
        System.out.println();
        tree.postOrder(tree.find(5));
        tree.remove(3);
        System.out.println();
        tree.inOrder(tree.find(5));
    }
}
