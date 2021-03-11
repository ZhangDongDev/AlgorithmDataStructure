import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args)  {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 对 source 数组中的数据按照从小到大排序
     *
     * @param source 待排序的数组
     */
    public static void sort(Comparable[] source) {
        // 创建堆
        // 交换 第一个元素和最后一个元素
        // 将第一个元素 下沉到 堆中正确的位置，更新数组中未排序的数量
        // 重复前两步，直到未排序的数量为 1
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        int N = heap.length - 1;
        while (N >= 1) {
            exchange(heap, 1, N);
            N--;
            sink(heap, 1, N);
        }
        System.arraycopy(heap, 1, source, 0, source.length);

    }

    private static void createHeap(Comparable[] source, Comparable[] heap) {
        // 1.把 source中的数据拷贝到heap中，从heap的1索引处开始填充
        System.arraycopy(source, 0, heap, 1, source.length);
        // 2.从heap索引的一半处开始倒叙遍历，对得到的每一个元素做下沉操作
        for (int i = (heap.length - 1) / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    private static void exchange(Comparable[] heap, int i, int j) {
        heap[0] = heap[i];
        heap[i] = heap[j];
        heap[j] = heap[0];
    }

    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static void sink(Comparable[] heap, int index, int range) {
        while (index * 2 <= range) {
            // 1. 找出index结点的两个子结点中的较大值
            int max = 2 * index;
            if (index * 2 + 1 <= range) { // 右子树存在
                if (less(heap, index * 2, index * 2 + 1)) {
                    max = index * 2 + 1;
                }
            }
            // 2. 如果当前结点的值小于子结点中的较大值，则更换
            if (less((heap), index, max)) {
                exchange(heap, index, max);
            }

            // 3.更新target
            index = max;
        }
    }
}
