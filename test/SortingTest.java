import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by babooloon on 2017/7/11.
 * Email: nickyangcchs@hotmail.com
 * Project: SortingAlgorithm
 */
class SortingTest {
    int[] a = new int[10];
    Sorting sort = new MergeSort();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        a = new int[]{-20, 3, 0, -3, 1, 2, 5, 20, 12, 14};
    }

    @Test
    void testOnNullArray() {
        a = null;
        sort.sort(a, 0, 0);
        Assertions.assertEquals(null, a);
    }

    @Test
    void testOnEmptyArray() {
        a = new int[]{};
        sort.sort(a, 0, 0);
        Assertions.assertArrayEquals(new int[]{}, a);
    }

    @Test
    void testOnPartialArray() {
        sort.sort(a, 1, 4);
        Assertions.assertArrayEquals(new int[]{-20, -3, 0, 1, 3, 2, 5, 20, 12, 14}, a);
    }

    @Test
    void testOnWholeArray() {
        sort.sort(a, 0, a.length - 1);
        Assertions.assertArrayEquals(new int[]{-20, -3, 0, 1, 2, 3, 5, 12, 14, 20}, a);
    }

    @Test
    void testOnRandomlyGeneratedArray() {
        a = new int[10000];
        int max = 100000;
        int min = -100000;
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt((max - min) + 1) + min;
        }
        sort.sort(a, 0, a.length - 1);
        int[] temp = Arrays.copyOf(a, a.length);
        Arrays.sort(temp);
        Assertions.assertArrayEquals(temp, a);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        a = null;
    }
}