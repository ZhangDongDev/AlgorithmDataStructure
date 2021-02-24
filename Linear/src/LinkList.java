import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {
    /**
     * 成员内部类：节点类
     * @param <T> 数据类型
     */
    private class Node<T> {
        private T item;
        private Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    // 记录头结点(指向第一个真正存储数据的节点)
    private Node head;
    // 记录链表的长度 0,1,2,3,
    private int N;


    /**
     * 构造方法
     * 创建LinkList对象
     */
    public LinkList() {
        // 初始化头结点
        head = new Node(null, null);
        N = 0;
    }


    /**
     * 置空线性表
     */
    public void clear() {
        head.next = null;
        head.item = null;
        N = 0;
    }

    /**
     * 获取链表的长度
     * @return 链表的长度
     */
    public int length() {
        return N;
    }


    /**
     * 判断链表是否为空
     * @return true表示链表为空，false表示链表非空
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取索引i对应位置的元素
     * @param i 索引
     * @return 索引i对应的元素
     */
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法！");
        }
        Node n = head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return (T) n.item;
    }

    /**
     * 向链表中添加新的元素 t
     * @param t 待添加的新元素
     */
    public void insert(T t) {
        // 找到最后一个节点
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        // 插入新节点
        Node newNode = new Node(t, null);
        n.next = newNode;
        // 链表长度+1
        N++;
    }

    /**
     * 向指定位置i处，添加元素 t
     *
     * @param i 指定位置i
     * @param t 待添加元素t
     */
    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("插入的位置不合法");
        }
        // 寻找 i 之前的节点
        Node previous = head;
        for (int index = 0; index < i; index++) {
            previous = previous.next;
        }

        // 位置 i 的节点
        Node current = previous.next;

        // 构建新节点, 并插入
        Node newNode = new Node(t, current);
        previous.next = newNode;

        // 长度 + 1
        N++;
    }

    /**
     * 删除指定位置 i 处的元素，并返回被删除的元素
     * @param i 指定位置i
     * @return 被删除的元素
     */
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        // 寻找i之前的元素
        Node previous = head;
        for (int index = 0; index < i; index++) {
            previous = previous.next;
        }

        // 当前 位置i 的节点
        Node current = previous.next;
        // 删除节点
        previous.next = current.next;
        // 长度更新
        N--;

        return (T) current.item;
    }

    /**
     * 查找元素 t 在链表中第一次出现的位置
     * @param t 元素t
     * @return 元素在链表中第一次出现的索引位置, 若元素不在列表中，返回 -1
     */
    public int indexOf(T t) {
        Node cursor = head;
        for (int i = 0; cursor.next != null; i++) {
            cursor = cursor.next;
            if (cursor.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回列表对象的一个迭代器
     * @return 迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkListIterator() ;
    }

    private class LinkListIterator implements Iterator {
        private Node n;

        public LinkListIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return (T) n.item;
        }
    }

}
