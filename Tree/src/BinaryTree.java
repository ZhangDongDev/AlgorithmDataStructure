public class BinaryTree<Key extends Comparable<Key>, Value> {
    // 记录根结点
    private Node root;
    // 记录树中的结点数量
    private int N;

    // 构造函数
    public BinaryTree() {
        this.root = null;
        this.N = 0;
    }

    private class Node {
        private Key key;
        private Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // 向树中插入一个新的键值对
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // 给指定树 x 上，添加一个键值对，并返回添加后的新树
    private Node put(Node x, Key key, Value value) {
        // 如果树为空，则直接插入节点 同时更新结点数量
        if (x == null) {
            N++;
            x = new Node(key, value, null, null);
            return x;
        } else if (x.key.compareTo(key) > 0) {
            // 如果树非空，比较待添加键值和当前结点的键值，
            // 小于当前结点键值，继续在当前结点的左子树中寻找
            x.left = put(x.left, key, value);

        } else if (x.key.compareTo(key) < 0) {
            // 大于当前结点键值，继续在当前结点的右子树中查找
            x.right = put(x.right, key, value);
        } else if (x.key.compareTo(key) == 0) {
            // 等于当前结点键值，则更新当前结点的value
            x.value = value;
        }
        return x;
    }

    // 根据 key 从树中找到对应的值
    public Value get(Key key) {
        return get(root,key);
    }

    // 根据 key 从指定的树 x 中，找到key对应的值
    private Value get(Node x, Key key) {
        return null;
    }

    // 根据 key 删除树中对应的键值对
    public void delete(Key key) {

    }

    // 删除指定树 x 上的键为 key 的键值对，并返回删除后的新树
    private Node delete(Node x, Key key) {
        return null;
    }

    // 获取树中元素的个数
    public int size() {
        return N;
    }

}