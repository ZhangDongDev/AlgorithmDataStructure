import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TowWayLinkList<T> implements Iterable<T> {
    List<Node<T>> node = new ArrayList<>();
    // 头结点
    private Node<T> head;
    // 尾结点
    private Node<T> last;
    // 链表长度
    private int N;

    // 构造方法
    public TowWayLinkList() {
        head = new Node<>(null, null, null);
        last = null;
        N = 0;
    }

    // 清空线性表
    public void clear() {
        last = null;
        head.next = null;
        head.previous = null;
        head.item = null;

        N = 0;
    }

    // 获取链表长度
    public int length() {
        return N;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 插入元素 t
    public void insert(T item) {
        if (last == null) {//空链表
            last = new Node<>(head, item, null);
            head.next = last;
        } else {// 链表非空
            Node<T> oldLast = last;
            Node<T> newNode = new Node<>(oldLast, item, last);
            oldLast.next = newNode;
            last = newNode;
        }
        //长度+1
        N++;
    }

    // 向指定位置 i 处插入元素 t
    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        // 找到位置 i 的前一个结点
        Node<T> previous = head;
        for (int index = 0; index < i; index++) {
            previous = previous.next;
        }
        // 当前结点
        Node<T> current = previous.next;
        // 构建新结点
        Node<T> newNode = new Node<>(previous, t, current);
        previous.next = newNode;
        current.previous = newNode;

        // 长度+1
        N++;
    }

    //获取指定位置i处的元素
    public T get(int i) {
        Node<T> n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    //找到元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node<T> n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.next.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //删除位置i处的元素，并返回该元素
    public T remove(int i) {
        //找到i位置的前一个结点
        Node<T> pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //找到i位置的结点
        Node<T> curr = pre.next;
        //找到i位置的下一个结点
        Node<T> nextNode = curr.next;
        //让i位置的前一个结点的下一个结点变为i位置的下一个结点
        pre.next = nextNode;
        //让i位置的下一个结点的上一个结点变为i位置的前一个结点
        nextNode.previous = pre;
        //元素的个数-1
        N--;
        return curr.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new TowWayLinkListIterator();
    }

    private class TowWayLinkListIterator implements Iterator<T> {
        private Node<T> cursor;

        public TowWayLinkListIterator() {
            this.cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public T next() {
            cursor = cursor.next;
            return cursor.item;
        }
    }

    // 结点类
    private class Node<E> {
        public Node<E> previous;
        public E item;
        public Node<E> next;

        public Node(Node<E> previous, E item, Node<E> next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }


}
