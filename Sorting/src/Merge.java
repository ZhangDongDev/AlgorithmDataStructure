public class Merge {
    //完成归并操作需要的辅助数组
    private static Comparable[] assist;

    public Merge() {
    }

    // 对数组内的元素进行排序
    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int left = 0;
        int right = a.length - 1;
        sort(a, left, right);

    }

    // 基于递归，实现归并排序
    // 对数组中 从索引 left 到索引 right 之间的元素进行排序
    private static void sort(Comparable[] a, int left, int right) {
        // 终止条件
        if (right <= left) {
            return;
        }

        int middle = (left + right) / 2;
        // 对 left 到 middle 之间的元素进行排序
        sort(a, left, middle);
        // 对 middle + 1 到 right 之间的元素进行排序
        sort(a, middle + 1, right);
        // 对 left 到 middle， middle+1  到 right 进行合并
        merge(a, left, middle, right);

    }

    // 从 索引 left 到 索引 middle 为一个子数组
    // 从 索引 middle + 1 到 索引 right 为一个子数组
    // 将数组 a 中的两个子数组的数据合并为一个有序的大数组
    private static void merge(Comparable[] a, int left, int middle, int right) {
        int i = left; // 定义一个指针，指向 assist 数组开始填充数据的索引
        int p1 = left; // 定义一个指针，指向第一个数组的第一个元素
        int p2 = middle + 1; // 定义一个指针，指向第二个数组的第一个元素

        // 比较左右两个数组中的元素大小，哪个小，则将其填充到assist数组中
        while (p1 <= middle && p2 <= right) {
            if (less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }
        // 上面的循环结束后，有一个数组的数组已经填充完毕，我们需要将
        // 将剩余的元素继续填充到 assist 数组中
        while (p1 <= middle) {
            assist[i++] = a[p1++];
        }

        while (p2 <= right) {
            assist[i++] = a[p2++];
        }

        // 将排序后的数据，覆盖原数组
        for (int index = left; index <= right; index++) {
            a[index] = assist[index];
        }
    }

    // 判断 a 是否小于 b， a < b 则返回 true
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    // 交换 a 数组中， 索引 i 和索引 j 中的值
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
