/**
 * 冒泡排序
 * 类名：
 * Bubble
 * 构造方法：
 * Bubble();
 * 成员方法：
 * public static void sort(Comparable[] a);
 * // 对数组内元素进行排序
 * private static boolean greater(Comparable a, Comparable b);
 * // 判断 a 是否大于 b
 * private static void exchange(Comparable[] a, int i, int j);
 * // 交换 a 数组中， 索引 i 和 索引 j 处的值
 */
public class Bubble {


    public static void sort(Comparable[] a) {
        // 需要进行 a.length - 1 次冒泡
        for (int i = 0; i < a.length - 1; i++) {
            // 从头开始， 依次比较
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exchange(a, j, j + 1);
                }
            }
        }
    }

    public static void sort_flag(Comparable[] a) {
        // 判断是否还要继续
        // 如果上次冒泡发生了交换，则还要继续,
        // 未发生交换， 则说明已经有序, 可以停止冒泡
        boolean flag = true;
        // 需要进行 a.length - 1 次冒泡
        for (int i = 0; i < a.length - 1 && flag; i++) {
            // 从头开始， 依次比较
            flag = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exchange(a, j, j + 1);
                    flag = true;
                }
            }
        }
    }


    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
