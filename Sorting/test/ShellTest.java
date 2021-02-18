import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShellTest {

    @Test
    void sort() {
        Integer[] a = {51, 61, 52, 82, 12, 63, 26, 11, 23, 99, 78};
        Shell.sort(a);
        System.out.println(Arrays.toString(a));
    }
}