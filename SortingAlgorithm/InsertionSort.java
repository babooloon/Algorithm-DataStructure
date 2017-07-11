/**
 * Created by babooloon on 2017/7/11.
 * Email: nickyangcchs@hotmail.com
 * Project: SortingAlgorithm
 */
public class InsertionSort implements Sorting {
    private static void insertionSort(int[] a, int start, int end) {
        for (int j = start + 1; j <= end; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= start && a[i] > key)
                a[i + 1] = a[i--];
            a[i + 1] = key;
        }
    }

    @Override
    public void sort(int[] a, int start, int end) {
        insertionSort(a, start, end);
    }
}
