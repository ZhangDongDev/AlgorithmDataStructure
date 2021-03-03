import org.junit.jupiter.api.Assertions;

class BinaryTreeTest {
    private BinaryTree<Integer, String> bt = new BinaryTree<>();


    @org.junit.jupiter.api.Test
    void put() {
        bt.put(2,"ni");
        bt.put(1, "刘老大");
        bt.put(4, "李四");
        bt.put(2, "周老二");
        bt.put(3, "张三");

    }
}