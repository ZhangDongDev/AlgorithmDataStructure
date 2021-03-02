public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    // 记录头结点
    private final Node head;
    // 记录符号表中元素个数
    private int N;

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    // 插入键值对
    public void put(Key key, Value value) {
        Node previous = head;
        Node current = head.next;
        // 1. 如果键值 key 大于当前结点的键值 ，则一直寻找下一个节点
        while (current != null &&  key.compareTo(current.key) > 0) {
            previous = current;
            current = current.next;
        }

        // 2. 如果键值 key 等于当前结点的键值，则更新当前结点的值
        if (current !=null && key.compareTo(current.key) ==0) {
            current.value = value;
            return;
        }
        // 3. 没有找到相同的 key 则插入新结点
        previous.next = new Node(key, value, current);
    }

    // 删除键值对
    public void delete(Key key) {
        Node cursor = head;
        while (cursor.next != null) {
            if (cursor.next.key.equals(key)) {
                cursor.next = cursor.next.next;
                N--;
                return;
            }
            cursor = cursor.next;
        }
    }

    // 获取键值对
    public Value get(Key key) {
        Node cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
            if (cursor.key == key) {
                return cursor.value;
            }
        }
        return null;
    }

    // 获取大小
    public int size() {
        return N;
    }

    // 符号表中的结点
    private class Node {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
