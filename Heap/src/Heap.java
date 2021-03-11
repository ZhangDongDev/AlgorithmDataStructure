public class Heap<T extends Comparable<T>> {
    private T[] items; // 用于存储数据的数组
    private int N; // 记录堆中的元素个数

    /**
     * 堆的构造函数，构造一个容量为 capacity 的堆
     *
     * @param capacity 堆的容量
     */
    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(20);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");


        String del;
        while ((del = heap.delMax()) != null) {
            System.out.print(del + ",");
        }
    }

    /**
     * 向堆中插入一个元素
     *
     * @param t 待插入的元素
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    /**
     * 删除堆中的最大元素，并返回这个元素
     *
     * @return 被删除的堆中最大元素
     */
    public T delMax() {
        T max = items[1];
        exchange(1, N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    /**
     * 使用上浮算法，使索引 index 中的元素在堆中处于正确的位置
     *
     * @param index 待上浮元素在数组中的索引
     */
    private void swim(int index) {
        while (index > 1) { // 如果已经到根结点，停止循环
            if (less(index / 2, index)) {
                exchange(index, index / 2);
            }
            index /= 2;
        }
    }

    /**
     * 使用下沉算法，使索引 index 中的元素在堆中处于正确的位置
     *
     * @param index 待下沉元素在数组中的索引
     */
    private void sink(int index) {
        // 如果已经到了最底层，则不需要循环
        while (index * 2 <= N) {
            //找到子结点中值较大的结点对应的索引
            int max;
            if (2 * index + 1 <= N) { // 存在右子结点
                if (less(index * 2, index * 2 + 1)) {
                    max = 2 * index + 1;
                } else {
                    max = 2 * index;
                }
            } else {// 不存在右子结点
                max = 2 * index;
            }

            // 比较当前结点和子结点中较大者，如果当前结点不小，结束循环
            if (!less(index, max)) {
                break;
            }

            exchange(index, max);
            index = max;
        }
    }

    /**
     * 判断堆中，索引i处的元素是否小于索引j处的元素
     *
     * @param i 索引i
     * @param j 索引j
     * @return 索引i处的元素小于索引j处的元素，返回true，否则返回false
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换索引 i 处的元素和索引 j 处的元素的值
     *
     * @param i 索引i
     * @param j 索引j
     */
    private void exchange(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
