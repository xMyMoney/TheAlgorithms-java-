package datastructures.trees.mytrees;

/**
 * 二叉树 左节点<根节点<右节点
 */
public class BinaryTree {

    /**
     * 这个见怪不怪啦 不解释了
     */
    class Node{
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        /**
         * 创建节点
         * @param value
         */
        public Node(int value){
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    /**
     * 一棵树的树根
     */
    private Node root;

    public BinaryTree(){
        root = null;
    }

    /**
     * 通过key查找节点
     * @param key
     * @return 如果找到该节点，则返回其父节点
     */
    public Node find(int key){
        Node current = root;
        while (current != null){
            if(key < current.data){
                //如果存储key的node不存在 则返回父节点
                if(current.left == null){
                    return current;
                }
                current = current.left;
            }else if(key > current.data){
                if(current.right == null){
                    return current;
                }
                current = current.right;
            }else {
                //找到值则返回其节点 用于删除
                return current;
            }
        }
        return null;
    }

    public void put(int value){
        Node newNode = new Node(value);
        //根节点为空 即插入第一个节点
        if(root == null){
            root = newNode;
        }else {
            //返回插入值的父节点
            Node parent = find(value);

            if(value < parent.data){
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            }else {
                parent.right = newNode;
                parent.right.parent = parent;
                return;
            }
        }
    }

    /**
     * 删除给定值的节点
     * @param value
     * @return
     */
    public boolean remove(int value){
        Node temp = find(value);
        //如果树中没有该节点
        if (temp.data != value){
            return false;
        }
        //删除没有孩子的节点
        if (temp.right == null && temp.left == null){
            if(temp == root){
                root = null;
            }else if(temp.parent.data < temp.data){
                temp.parent.right = null;
            }else {
                temp.parent.left = null;
            }
            return true;
        }
        //删除有两个孩子的节点
        else if (temp.left != null && temp.right != null){
            Node successor = findSuccessor(temp);
            //被删节点的右孩子的左孩子为被删除节点的左孩子
            successor.left = temp.left;
            successor.left.parent = successor;

            //看不懂  留着先吧 我也不知道啊
            //If the successor has a right child, the child's grandparent is it's new parent
            if(successor.parent!=temp){
                if(successor.right!=null){
                    successor.right.parent = successor.parent;
                    successor.parent.left = successor.right;
                    successor.right = temp.right;
                    successor.right.parent = successor;
                }else{
                    successor.parent.left=null;
                    successor.right=temp.right;
                    successor.right.parent=successor;
                }
            }

            //当删除的是根节点时
            if (temp == root) {
                successor.parent = null;
                root = successor;
                return true;
            }
            //不是根节点
            else {
                successor.parent = temp.parent;
                //用于判断删除节点在左是右子树的位置
                if(temp.parent.data < temp.data){
                    //在右子树
                    temp.parent.right = successor;
                }else {
                    //在左子树
                    temp.parent.left = successor;
                }
                return true;
            }
        }
        //只有一个节点
        else {
            //如果这个孩子是右孩子
            if (temp.right != null) {
                //如果删除是根节点
                if (temp == root) {
                    root = temp.right;
                    return true;
                }

                temp.right.parent = temp.parent;
                if (temp.data < temp.parent.data){
                    temp.parent.left = temp.right;
                }
                else{
                    temp.parent.right = temp.right;
                }
                return true;
            }
            //如果是左孩子
            else {
                //都一样的 不做解释了 真的懒
                if (temp == root) {
                    root = temp.left;
                    return true;
                }

                temp.left.parent = temp.parent;
                if (temp.data < temp.parent.data){
                    temp.parent.left = temp.left;
                }
                else{
                    temp.parent.right = temp.left;
                }
                return true;
            }
        }
    }

    /**
     * 返回后继节点
     * @param n
     * @return
     */
    public Node findSuccessor(Node n) {
        if (n.right == null){
            return n;
        }
        Node current = n.right;
        Node parent = n.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    /**
     * 获得根节点
     * @return
     */
    public Node getRoot() {
        return root;
    }


    /**
     *中序遍历 左根右
     * @param localRoot 开始遍历的节点
     */
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    /**
     *前序遍历 根左右
     * @param localRoot
     */
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    /**
     *后序遍历 左右根
     * @param localRoot
     */
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }

}
