import java.util.LinkedList;
import java.util.Queue;

public class PaperFolding {
    public static void main(String[] args) {
        Node tree = createTree(3);
        printTree(tree);
    }
    // 创建深度为N的折痕树
    private static Node createTree(int N) {
        Node root = null;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                // 1. 第一次对折，只有一个折痕，创建根结点
                root = new Node("down", null, null);
            } else {
                //2.当前不是第一次对折
                //定义一个辅助队列，通过层序遍历的思想，找到叶子结点，叶子结点添加子节点
                Queue<Node> queue = new LinkedList<>();
                queue.offer(root);

                //循环遍历队列
                while (!queue.isEmpty()) {
                    //从队列中弹出一个结点
                    Node tmp = queue.poll();
                    //如果有左子结点，则把左子结点放入到队列中
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    //如果有右子结点，则把右子结点放入到队列中
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                    //如果同时没有左子结点和右子结点，那么证明该节点是叶子结点，只需要给该节点添加左子结点和右子结点即可
                    if (tmp.left == null && tmp.right == null) {
                        tmp.left = new Node("down", null, null);
                        tmp.right = new Node("up", null, null);
                    }
                }
            }
        }
        return root;
    }

    // 使用中序遍历，打印树中所有节点内容
    private static void printTree(Node tree) {
        if (tree == null) {
            return;
        }
        printTree(tree.left);
        System.out.print(tree.item + " ");
        printTree(tree.right);
    }

    private static class Node {
        String item;
        Node left;
        Node right;

        public Node(String item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}
