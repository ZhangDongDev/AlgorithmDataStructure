public class Node<T> {
    // 存储数据元素
    public T item;

    // 指向上一个节点
    public Node previous;

    // 指向下一个节点
    public Node next;

    /**
     * 构造方法，创建Node对象
     *
     * @param item Node中存储的数据
     * @param previous 指向上一个Node节点
     * @param next 指向下一个Node节点
     */
    public Node(T item,Node previous, Node next) {
        this.item = item;
        this.next = next;
    }
}
