package datastructure.lists;

public class SingleCircleLinkedList<E> extends AbstractList<E>{
    private Node first;

    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
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

    //单向链表与单向循环链表主要处理区别在于 add   remove
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if(index == 0){
            Node<E> newFirst = new Node<>(element, first);
            //插入头节点  需要拿到尾节点，将其next指向新节点
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;
            first = newFirst;
        }else {
            Node<E> prev = node(index - 1);  //index位置前一个node
            prev.next = new Node<E>(element,prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;     //被删除的node
        if(index == 0){
            Node<E> last = node(size - 1);
            first = first.next;   //其实就是本身
            last.next = first;
        }else {
            Node<E> prev = node(index - 1);
            node = prev.next;
           // prev.next = prev.next.next;
            prev.next = node.next;
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

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
