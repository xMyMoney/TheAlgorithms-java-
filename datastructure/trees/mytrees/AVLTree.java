package datastructures.trees.mytrees;

public class AVLTree {
    /**
     * 根节点
     */
    private Node root;

    private class Node {
        //值
        private int key;
        //平衡因子
        private int balance;
        //节点高度 左右子树高度最高的
        private int height;
        private Node left, right, parent;

        Node(int k, Node p) {
            key = k;
            parent = p;
        }
    }

    public boolean insert(int key) {
        //插入根节点
        if (root == null){
            root = new Node(key, null);
        }
        else {
            Node n = root;
            Node parent;
            //寻找合适位置插入新节点
            while (true) {

                if (n.key == key){
                    return false;
                }

                parent = n;

                boolean goLeft = n.key > key;
                n = goLeft ? n.left : n.right;

                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(key, parent);
                    } else {
                        parent.right = new Node(key, parent);
                    }
                    //调整平衡树
                    rebalance(parent);
                    break;
                }
            }
        }
        return true;
    }

    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            //根节点 且没有孩子节点
            if (node.parent == null){
                root = null;
            }
            else {
                //叶子节点
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                //调整失衡
                rebalance(parent);
            }
            return;
        }
        if (node.left != null) {
            Node child = node.left;
            while (child.right != null){
                child = child.right;
            }
            node.key = child.key;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) {
                child = child.left;
            }
            node.key = child.key;
            delete(child);
        }
    }

    /**
     * 按值删除节点
     * @param delKey
     */
    public void delete(int delKey) {
        if (root == null){
            return;
        }
        Node node = root;
        Node child = root;

        //寻找要删除节点
        while (child != null) {
            node = child;
            child = delKey >= node.key ? node.right : node.left;
            if (delKey == node.key) {
                delete(node);
                return;
            }
        }
    }

    /**
     * 调整失衡
     * @param n 注意: n 并不是新节点 而是新节点的parent
     *          若新节点的parent的parent不为空  递归 依次往上寻找不平衡节点
     */
    private void rebalance(Node n) {
        //修改平衡因子 +1
        setBalance(n);

        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right)){
                //LL型 右旋
                n = rotateRight(n);
            }
            else{
                //LR型
                n = rotateLeftThenRight(n);
            }
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left)){
                //RR型 左旋
                n = rotateLeft(n);
            }
            else{
                //RL型
                n = rotateRightThenLeft(n);
            }
        }
        //递归
        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }

    /**
     *左旋
     * @param a 失衡节点
     * @return
     */
    private Node rotateLeft(Node a) {

        Node b = a.right;
        b.parent = a.parent;

        a.right = b.left;

        if (a.right != null){
            a.right.parent = a;
        }

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    /**
     * 右旋
     * @param a
     * @return
     */
    private Node rotateRight(Node a) {

        Node b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null){
            a.left.parent = a;
        }

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    /**
     * 获取节点高度
     * @param n
     * @return
     */
    private int height(Node n) {
        if (n == null){
            return -1;
        }
        return n.height;
    }

    /**
     * 设置平衡因子
     * @param nodes 不定数量的传参
     */
    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }

    public void printBalance() {
        printBalance(root);
    }

    /**
     * 输出所有节点平衡因子
     * @param n
     */
    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }
    }

    /**
     * 修改平衡因子 +1
     * @param node
     */
    private void reheight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    /**
     * 前序遍历好了
     * @param localRoot
     */
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.key + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        System.out.println("Inserting values 1 to 10");
        for (int i = 1; i <= 10; i++){
            tree.insert(i);
        }
        System.out.print("Printing balance: ");
        tree.printBalance();
        System.out.println();
        tree.preOrder(tree.root);
    }
}
