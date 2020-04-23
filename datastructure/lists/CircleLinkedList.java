package datastructure.lists;

public class CircleLinkedList<E> extends AbstractList<E>{
    private Node<E> first;
    private Node<E> last;

    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev,E element, Node<E> next){
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if(index == size){    //从尾部添加
            Node<E> oldLast = last;
            // oldLast指向原链表的尾节点, next指向首节点
            last = new Node<>(oldLast,element,first);
            if(oldLast == null){    //添加第一个元素
                first = last;
                first.next = first;
                first.prev = first;
            }else {
                oldLast.next = last;
                first.prev =last;
            }
        }else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev,element,next);
            next.prev = node;
            prev.next = node;
            if(next == first){    //往头部添加   index == 0
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        //删除头节点
        if(size == 1){
            first = null;
            last = null;
        }else {
            node = node(index);  //需要删除的节点
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if(node == first){    //删除头部元素 index == 0
                first = next;
            }
            if(node == last){   //删除尾部元素  index == size - 1
                last = prev;
            }
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 返回Index位置的node
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);

        if(index < (size >> 1)){
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }


    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(node.element);
            node = node.next;
        }
        stringBuilder.append("]");
//        另外一种遍历node
//        Node<E> node1 = first;
//        while (node1 != null){
//            node1 = node1.next;
//        }

        return stringBuilder.toString();
    }
}
