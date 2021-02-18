import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BubbleTest {
    private Integer[] a = {51, 61, 52, 82, 12, 63, 26, 11, 23, 99, 78};

    @Test
    void sort_flag() {
        Bubble.sort_flag(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    void sort() {
        Bubble.sort_flag(a);
        System.out.println(Arrays.toString(a));
    }
}