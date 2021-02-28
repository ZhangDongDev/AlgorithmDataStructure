import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

class LinkListTest {
    LinkList<String> list = new LinkList<>();

    @BeforeEach
    void init() {
        list.insert("11");
        list.insert("22");
        list.insert("33");
        list.insert("44");
    }

    @AfterEach
    void show() {
        for (String s : list
        ) {

            System.out.println(s);
        }
    }

    @Test
    void clear() {
        System.out.println(list.length());
        list.clear();
        System.out.println(list.length());
    }

    @Test
    void length() {
        Assertions.assertEquals(4,list.length());
        System.out.println(list.length());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(list.isEmpty());
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void get() {
        Assertions.assertEquals("11",list.get(0));
    }

    @Test
    void insert() {
        list.insert("insert");

    }

    @Test
    void testInsert() {
        list.insert(0,"hhh");
    }

    @Test
    void remove() {
        list.remove(3);
    }

    @Test
    void indexOf() {
        System.out.println(list.indexOf("22"));
    }

    @Test
    void iterator() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void reverse() {
        list.reserve();
    }

    @Test
    void getMid() {

        list.insert("55");
        String mid = list.getMid();
        System.out.println(mid);
    }
}