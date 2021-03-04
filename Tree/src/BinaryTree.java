import java.util.LinkedList;
import java.util.Queue;

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

    public static void main(String[] args) {
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(2, "ni");
        bt.put(1, "刘老大");
        bt.put(4, "李四");
        bt.put(2, "周老二");
        bt.put(3, "张三");

        BinaryTree<Integer, String>.Node min = bt.findMin(bt.root.left);

        System.out.println(min.value);

        // bt.delete(4);
        bt.put(12, "刘");
        bt.put(41, "四");
        bt.put(8, "二");

        System.out.println(bt.preOrderTraversal());
        System.out.println(bt.inOrderTraversal());
        System.out.println(bt.postOrderTraversal());
        System.out.println(bt.levelTraversal());
    }

    // 向树中插入一个新的键值对
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // 给指定树 x 上，添加一个键值对，并返回添加后的新树
    private Node put(Node x, Key key, Value value) {
        // 如果树为空，则直接插入节点 同时更新结点数量，返回树
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
        return get(root, key);
    }

    // 根据 key 从指定的树 x 中，找到key对应的值
    private Value get(Node x, Key key) {
        // 树为空，返回 null
        if (x == null) {
            return null;
        }
        // 树非空
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            // key值等于当前结点key值，直接返回
            return x.value;
        } else if (cmp > 0) {
            // key值大于当前结点key值，从当前结点的右子树寻找
            return get(x.right, key);
        } else {
            // key值小于当前结点key值，从当前结点的左子树进行寻找
            return get(x.left, key);
        }
    }

    // 根据 key 删除树中对应的键值对
    public void delete(Key key) {
        root = delete(root, key);

    }

    // 删除指定树 x 上的键为 key 的键值对，并返回删除后的新树
    private Node delete(Node x, Key key) {
        /*
        递归
        终止条件：树为空，返回null。
        树非空，key 大于当前结点的key，在当前结点的右子树上进行删除，更新当前结点的右子树
               key 小于当前结点的key，在当前结点的左子树上进行删除，更新当前结点的左子树
               key 等于当前结点的key，
                    如果当前结点为叶子结点，将其父结点指向其的引用置空即可
                    如果当前结点仅有左子树或者右子树，将其父结点的引用指向其左子树或者右子树即可
                    如果当前结点左右子树均存在，找到其右子树最小的节点（一定为叶子节点），删除该节点，使当前结点的父节点指向该节点，设置该节点的左右子树为当前结点的左右子树
         */

        if (x == null) {
            return null;
        }

        int compare = key.compareTo(x.key);
        if (compare > 0) {
            x.right = delete(x.right, key);
        } else if (compare < 0) {
            x.left = delete(x.left, key);
        } else {
            // 该节点就是要删除的节点
            N--;

            // 左子树为空
            if (x.left == null) {
                return x.right;
            }

            // 右子树为空
            if (x.right == null) {
                return x.left;
            }

            // 左右子树均存在
            // 1. 找到待删除节点的右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            // 2. 删除右子树中最小的节点
            if (minNode == x.right) {
                x.right = x.right.right;
            }
            Node temp = x.right;
            while (temp.left != null) {
                if (temp.left.left == null) {
                    temp.left = null;
                } else {
                    temp = temp.left;
                }
            }

            // 3. x 节点的左子树、右子树 被 minNode节点继承
            minNode.left = x.left;
            minNode.right = x.right;

            // 4. x 结点的父节点指向 minNode
            x = minNode;
        }
        return x;
    }


    // 获取树中元素的个数
    public int size() {
        return N;
    }

    // 找出整个树中最小的键
    public Key min() {
        return findMin(root).key;
    }

    // 找到当前树的最小值
    private Node findMin(Node x) {
        if (x == null) {
            return null;
        }
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    // 找出整个树中最大的键
    public Key max() {
        return findMax(root).key;
    }

    // 找到当前树的最小值
    private Node findMax(Node x) {
        if (x == null) {
            return null;
        }
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    // 前序遍历，获取整个树中所有的键
    public Queue<Key> preOrderTraversal() {
        Queue<Key> keys = new LinkedList<>();
        preOrderTraversal(root, keys);
        return keys;
    }

    // 前序遍历，将指定的树 x 中的所有键放入到 keys 队列中
    private void preOrderTraversal(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        // 将根节点的key放入到队列中
        keys.add(x.key);
        // 找到当前结点的左子树，如果不为空，则递归遍历左子树
        if (x.left != null) {
            preOrderTraversal(x.left, keys);
        }
        // 找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null) {
            preOrderTraversal(x.right, keys);
        }
    }

    // 中序遍历
    public Queue<Key> inOrderTraversal() {
        Queue<Key> keys = new LinkedList<>();
        inOrderTraversal(root, keys);
        return keys;
    }

    private void inOrderTraversal(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        if (x.left != null) {
            inOrderTraversal(x.left, keys);
        }
        keys.add(x.key);
        if (x.right != null) {
            inOrderTraversal(x.right, keys);
        }
    }

    // 后序遍历
    public Queue<Key> postOrderTraversal() {
        Queue<Key> keys = new LinkedList<>();
        postOrderTraversal(root, keys);
        return keys;
    }

    private void postOrderTraversal(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            postOrderTraversal(x.left, keys);
        }
        if (x.right != null) {
            postOrderTraversal(x.right, keys);
        }
        keys.add(x.key);
    }

    public Queue<Key> levelTraversal() {
        Queue<Key> keys = new LinkedList<>();
        Queue<Node> nodes = new LinkedList<>();

        nodes.offer(root);
        while (!nodes.isEmpty()) {
            Node temp = nodes.poll();
            keys.offer(temp.key);
            if (temp.left != null) {
                nodes.offer(temp.left);
            }
            if (temp.right != null) {
                nodes.offer(temp.right);
            }
        }
        return keys;
    }

    private class Node {
        public Node left;
        public Node right;
        public Key key;
        public Value value;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}