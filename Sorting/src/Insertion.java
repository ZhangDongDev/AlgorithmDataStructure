public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            // 当前元素为 a[i]，依次和 i 前面的元素比较， 找到一个小于等于 a[i] 的元素
            for (int j = i; j > 0; j--) {
                if (greater(a[j - 1], a[j])) {
                    exchange(a, j - 1, j);
                } else {
                    //找到该元素，结束
                    break;
                }
            }
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
