package datastructure.lists;

public class SingleLinkedList<E> extends AbstractList<E>{
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

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if(index == 0){
            first = new Node<E>(element,first);  //index为0时的处理
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
            first = first.next;
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
