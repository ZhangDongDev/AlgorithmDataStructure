public class Quick {
    public static void sort(Comparable[] a) {
        int left = 0;
        int right = a.length - 1;
        sort(a, left, right);
    }

    // 对数组a中，索引left 到索引right 之间的元素进行排序
    private static void sort(Comparable[] a, int left, int right) {
        // 终止条件
        if (right <= left) {
            return;
        }

        // 对a数组中， 从 left 到 right 的元素进行切分
        int partition = partition(a, left, right);

        // 对左边、右边，分组的元素进行排序
        sort(a, left, partition - 1);
        sort(a, partition + 1, right);

    }

    // 对数组a中， 索引left 到索引right 之间的元素进行分组
    // 并返回分组界限对应的索引
    private static int partition(Comparable[] a, int left, int right) {
        Comparable key = a[left]; // 将最左边的元素当做基准值
        int p1 = left; // 定义一个左侧指针，初始指向最左边的元素
        int p2 = right + 1; // 定义一个右侧指针，初始指向最右侧的元素的下一个位置

        // 进行切分
        while (true) {
            // 先 从右往左 扫描，找到一个比基准值小的元素
            while (less(key, a[--p2])) { // 循环停止，证明找到一个比基准值小的元素
                if (p2 == left) {
                    break; // 已经扫描到最左边，无需继续扫描
                }
            }
            // 再 从左往右 扫描，找到一个比基准值大的元素
            while (less(a[p1++], key)) { // 循环停止，证明找到一个比基准值大的元素
                if (p1 == right) {
                    break; //已经扫描到最右边，无需继续扫描
                }
            }
            // 如果扫描完，结束循环
            if (p1 >= p2) {
                break; // 扫描完，结束循环
            } else {
                // 交换 p1 和 p2 索引处的元素
                exchange(a, p1, p2);
            }
        }// while(true) 结束

        // 交换最后 p2 (右→左，找到比基准值小的元素) 索引和基准值所在索引处的值
        exchange(a, p2, left);

        return p2; // p2就是切分的界限
    }

    // 判断 a 是否小于 b ， 小于返回 true
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    // 交换数组a中，索引i和索引j处对应的值
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
