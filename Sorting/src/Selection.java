public class Selection {
    /*
        对数组a中的元素进行排序
     */
    public static void sort(Comparable[] a) {
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[min], a[j])) {
                    min = j;
                }
            }
            exchange(a, min, i);
        }
    }

    /*
        比较 元素a 是否大于 元素b
     */
    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    /*
        数组元素 i 和 j 交换位置
     */
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
