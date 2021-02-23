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


    public boolean isEmpty() {
        return N == 0;
    }

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
        public Node next() {
            return null;
        }
    }

}
