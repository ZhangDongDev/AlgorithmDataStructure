public class Shell {
    public static void sort(Comparable[] a) {
        //N代表数组长度
        int N = a.length;
        // 确定增长量h的最大值
        int h = 1;
        while (h < N / 2) {
            h = 2 * h + 1;
        }

        // 当增长量小于1时，排序结束
        while (h >= 1) {
            //找到待插入的元素, [0,h-1]分别是h个组的第一个元素
            for (int i = h; i < N; i++) {
                // a[i]就是待插入的元素, 把 a[i] 插入到a[i-h],a[i-2h]...的序列中
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exchange(a, j - h, j);
                    } else {
                        // 有序则停止
                        break;
                    }
                }
            }
            h /= 2;
        }
    }


    /**
     * 判断a是否大于b, 若 a>b 返回 true；若 a<b 返回 false.
     * @param a 待比较的第一个参数
     * @param b 待比较的第二个参数
     * @return 若 a>b 返回 true；若 a<b 返回 false.
     */
    private static boolean greater(Comparable a,Comparable b) {
        return a.compareTo(b) > 0;
    }

    /**
     * 交换数组中相应位置（如位置j 和位置i）的数据内容
     * @param a 数组
     * @param i 待交换的数组位置的索引 i
     * @param j 待交换的数组位置的索引 j
     */
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
