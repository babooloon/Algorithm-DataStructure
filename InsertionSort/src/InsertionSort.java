/**
 * Created by babooloon on 2017/7/11.
 * Email: nickyangcchs@hotmail.com
 */
class InsertionSort {
    static void insertionSort(int[] a, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = a[i];
            while (i > start && a[i - 1] > key) {
                a[i] = a[i - 1];
                i--;
            }
            a[i] = key;
        }
    }
}
