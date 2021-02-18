import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {
    /**
     * 存储元素的数组
     */
    private T[] elements;
    /**
     * 记录当前顺序表中的元素个数
     */
    private int N = 0;

    /**
     * 创建容量为 capacity 的 SequenceList 对象
     *
     * @param capacity 创建的顺序表的容量为 capacity
     */
    public SequenceList(int capacity) {
        this.elements = (T[]) new Object[capacity];
        N = 0;
    }

    /**
     * 置空线性表
     */
    public void clear() {
        this.N = 0;
    }

    /**
     * 判断当前线性表是否为空，是返回true，否返回false
     *
     * @return 当前线性表为空，返回true；不为空，返回false
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取线性表中元素的个数
     *
     * @return 线性表中元素的个数
     */
    public int length() {
        return N;
    }

    /**
     * 获取指定索引位置的元素
     *
     * @param i 索引
     * @return 索引对应位置的元素
     */
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("当前元素不存在！");
        }

        return elements[i];
    }

    /**
     * 在线性表中添加一个元素
     *
     * @param t 待插入的元素
     */
    public void insert(T t) {
        if (N == elements.length) {
            resize(elements.length * 2);
        }

        elements[N++] = t;
    }

    /**
     * 在线性表第 i 个元素之前插入一个值为 t 的数据元素
     *
     * @param i 第 i 个元素
     * @param t 待插入的数据元素
     */
    public void insert(int i, T t) {
        if (N == elements.length) {
            resize(elements.length * 2);
        }

        if (i < 0 || i > N) {
            throw new RuntimeException("插入位置不合法");
        }
        // 将元素进行后移
        for (int index = N; index > i; index--) {
            elements[index] = elements[index - 1];
        }

        //  插入元素
        elements[i] = t;

        // 元素数量 +1
        N++;
    }


    /**
     * 删除指定位置 i 处的元素，并返回该元素
     *
     * @param i 待删除的元素的索引
     * @return 被删除的元素
     */
    public T remove(int i) {
        if (i < 0 || i > N) {
            throw new RuntimeException("要删除的元素不存在");
        }

        T result = elements[i];

        // 将后面的元素，前移
        for (int j = i; j < N - 1; j++) {
            elements[j] = elements[j + 1];
        }

        // 当前元素的数量减一
        N--;

        // 当前元素已经不足数组大小的四分之一，则重置数组大小
        if (N > 0 && N < elements.length / 4) {
            resize(elements.length / 2);
        }

        return result;
    }

    /**
     * 查找t元素第一次出现的位置
     *
     * @param t 元素t
     * @return 元素t第一次出现时的索引，如果元素不存在，则返回 -1
     */
    public int indexOf(T t) {
        if (t == null) {
            throw new RuntimeException("查找的元素不合法");
        }

        for (int i = 0; i < N; i++) {
            if (elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 重写 toString 方法
     *
     * @return SequenceList 对象对应的字符串
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stringBuilder.append(elements[i]).append(" ");
        }
        return stringBuilder.toString();
    }


    /**
     * 为了 SequenceList 也能支持foreach循环，需要实现以下操作
     * 1. 让 SequenceList 实现 Iteratble 接口，重写 iterator 方法；
     * 2. 在 SequenceList 内部提供一个内部类 SIterator，实现 Iterator 接口，重写 hasNext 方法和 next 方法
     * <p>
     * 重写 iterator 方法
     *
     * @return 返回 Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    /**
     * 改变顺序表的容量
     *
     * @param newSize 顺序表的新容量
     */
    private void resize(int newSize) {
        // 记录旧数组
        T[] temp = elements;
        // 创建新数组
        elements = (T[]) new Object[newSize];
        // 将旧数组中的元素拷贝到新数组中
        for (int i = 0; i < N; i++) {
            elements[i] = temp[i];
        }
    }

    /**
     * 返回顺序表的容量
     *
     * @return 顺序表当前的容量
     */
    public int capacity() {
        return elements.length;
    }

    /**
     * 在 SequenceList 内部提供一个内部列 SIterator，实现 Iterator 接口，重写 hasNext 方法和 next 方法
     */
    private class SIterator implements Iterator<T> {

        private int current;

        public SIterator() {
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < N;
        }

        @Override
        public T next() {
            return elements[current++];
        }
    }


}
