import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionTest {

    @Test
    void sort() {
        Integer[] a = {12, 12, 45, 65, 72, 1, 13, 98, 21, 24, 75, 94, 16, 28};
        Selection.sort(a);
        System.out.println("a = " + Arrays.toString(a));
    }
}