public class LinkList {
    // 记录头结点
    private Node head;
    // 记录链表的长度
    private int N;

    /**
     * 成员内部类：节点类
     * @param <T>
     */
    private class Node<T> {
        private T item;
        private Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
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

}
