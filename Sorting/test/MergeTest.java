import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {
    private Integer[] a = {51, 61, 52, 82, 12, 63, 26, 11, 23, 99, 78};

    @Test
    public void testSort() {
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }

}