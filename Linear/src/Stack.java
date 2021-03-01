import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    //记录头结点（类比栈顶指针）
    private Node<T> head;
    //记录元素个数
    private int count;

    public Stack() {
        this.head = new Node<>(null, null);
        this.count = 0;
    }

    public void push(T t) {
        Node<T> old = head.next;
        head.next = new Node<>(t, old);
        count ++;
    }

    public T pop() {
        Node<T> old = head.next;
        if (old == null) {
            return null;
        }
        head.next = old.next;
        count--;
        return old.item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator() ;
    }

    private class SIterator implements Iterator<T>{
        private Node<T> ptr;
        public SIterator() {
            this.ptr = head;

        }

        @Override
        public boolean hasNext() {
            return ptr.next != null;
        }

        @Override
        public T next() {
            ptr = ptr.next;
            return ptr.item;
        }
    }


    private static class Node<E> {
        public E item;
        public Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

}
