import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SequenceListTest {

    // 测试构造函数
    SequenceList<String> sequenceList = new SequenceList<>(10);

    @org.junit.jupiter.api.Test
    void clear() {
        insert();
        System.out.println("清理前: ");
        System.out.println(sequenceList);
        sequenceList.clear();
        System.out.println("清理后: ");
        System.out.println(sequenceList);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        System.out.println(sequenceList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void length() {
        insert();
        System.out.println(sequenceList.length());
    }

    @org.junit.jupiter.api.Test
    void get() {
        insert();
        System.out.println(sequenceList.get(3));

    }

    @org.junit.jupiter.api.Test
    void insert() {
        sequenceList.insert("zhangsan");
        sequenceList.insert("lisi");
        sequenceList.insert("王五");
        sequenceList.insert("不利苏");
        System.out.println(sequenceList);
    }


    @org.junit.jupiter.api.Test
    void remove() {
        insert();
        sequenceList.remove(0);
        System.out.println(sequenceList);

    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        insert();
        System.out.println(sequenceList.indexOf("lisi"));
    }

    @Test
    void testForEach() {
        insert();
        System.out.println("----");
        for (String s :
                sequenceList) {
            System.out.println(s);
        }
        System.out.println("---");
    }

    @Test
    void capacity() {
        insert();
        insert();
        insert();
        System.out.println("sequenceList.capacity() = " + sequenceList.capacity());
    }
}