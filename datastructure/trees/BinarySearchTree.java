package datastructures.trees;

import java.util.Comparator;

public class BinarySearchTree<E> {

    /**
     * 节点
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
        public boolean hasTwoChildren(){
            return left != null && right != null;
        }
    }

    /**
     *    元素的个数
      */
    private int size;
    /**
     * 根节点
     */
    private Node<E> root;
    /**
     * 比较器
     */
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }


    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     *  是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 清空所有元素
     */
    public void clear(){

    }

    /**
     * 添加元素
     * @param element
     */
    public void add(E element){
        elementNotNullCheck(element);

        //添加第一个节点
        if(root == null){
            root = new Node<>(element,null);
            size++;
            return;
        }
        //添加不是第一个节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null){
            cmp = compare(element,node.element);
            parent = node;
            if(cmp > 0){
                node = node.right;
            }else if(cmp < 0){
                node = node.left;
            }else {
                node.element = element;
                return;
            }
        }
        //最后一个节点
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }
    // 删除元素
    public void remove(E element){
        remove(node(element));
    }
    private void remove(Node<E> node){
        if (node == null){
            return;
        }
        size--;
        // 度为2的节点
        if (node.hasTwoChildren()) {
            // 找到后继节点
            Node<E> s = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = s.element;
            // 删除后继节点
            node = s;
        }

        // 删除node节点（node的度必然是1或者0）
        Node<E> replacement = node.left != null ? node.left : node.right;
        // node是度为1的节点
        if (replacement != null) {
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的left、right的指向
            // node是度为1的节点并且是根节点
            if (node.parent == null) {
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else { // node == node.parent.right
                node.parent.right = replacement;
            }
        }
        // node是叶子节点并且是根节点
        else if (node.parent == null) {
            root = null;
        } else { // node是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else { // node == node.parent.right
                node.parent.right = null;
            }
        }
    }

    private Node<E> node(E element){
        Node<E> node = root;
        while (node != null){
            int cmp = compare(element,node.element);
            if(cmp == 0){
                return node;
            }
            if(cmp > 0){
                node = node.right;
            }else {
                node = node.left;
            }
        }return null;
    }

    // 是否包含某元素
    public boolean contains(E element){
        return false;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    private void preorderTraversal(Node<E> node) {
        // 退出条件
        if (node == null){
            return;
        }
        // 打印节点值
        System.out.println(node.element);
        // 前序遍历左子树
       preorderTraversal(node.left);
        // 前序遍历右子树
        preorderTraversal(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    private void inorderTraversal(Node<E> node) {
        // 退出条件
        if (node == null){
            return;
        }
        // 中序遍历左子树
        inorderTraversal(node.left);
        // 打印节点值
        System.out.println(node.element);
        // 中序遍历右子树
        inorderTraversal(node.right);
    }

    /**
     * 后续遍历
     * @param node
     */
    private void postorderTraversal(Node<E> node) {
        // 退出条件
        if (node == null){
            return;
        }
        // 后序遍历左子树
        postorderTraversal(node.left);
        // 后序遍历右子树
        postorderTraversal(node.right);
        // 打印节点值
        System.out.println(node.element);
    }

    /**
     * 前继节点
     * @param node
     * @return
     */
    protected Node<E> predecessor(Node<E> node) {
        if (node == null){
            return null;
        }
        // 前驱节点在左子树当中（left.right.right.right....）
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        // node.parent == null
        // node == node.parent.right
        return node.parent;
    }

    /**
     * 后继节点
     * @param node
     * @return
     */
    protected Node<E> successor(Node<E> node) {
        if(node == null){
            return null;
        }
        // 前驱节点在左子树当中（right.left.left.left....）
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }
}
