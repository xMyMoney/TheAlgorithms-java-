package datastructure.lists;

public class ArrayList<E> extends AbstractList<E>{
    /**
     * 所有元素
     */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity){
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[])new Object[capacity];
    }

    //默认情况
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1); // 至少保证size+1容量

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size ++;
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E oldElementE = elements[index];
        for (int i = index ; i < size-  1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return oldElementE;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }

        return ELEMENT_NOT_FOUND;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        // 自定义类的打印方法
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }



    private void ensureCapacity(int capacity) {
        // 1. 判断容量长度是否比最少容量大
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 2. 创建新的容量 1.5 倍
        // 		>> 1 右移一位相当于除以2
        // 		<< 1 左移一位相当于乘以2
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}