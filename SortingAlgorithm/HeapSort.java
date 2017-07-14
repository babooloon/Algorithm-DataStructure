/**
 * Created by babooloon on 2017/7/14.
 * Email: nickyangcchs@hotmail.com
 * Project: SortingAlgorithm
 */
public class HeapSort implements Sorting {
    public static void main(String args[]) {
        int[] a = {-20, 3, 0, -3, 1, 2, 5, 20, 12, 14};
        heapSort(a, 0, 8);
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.println(a[i]);
            }
        }
    }

    private static void maxHeapify(int[] a, int i, int end) {
        int l = (i << 1) + 1;
        int r = l + 1;
        int largest = i;
        if (l <= end && a[l] > a[i]) {
            largest = l;
        }
        if (r <= end && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify(a, largest, end);
        }
    }

    private static void maxHeapifyIterative(int[] a, int i, int end) {
        int l = (i << 1) + 1;
        int r = l + 1;
        int largest = i;
        int key = a[i];
        while (i <= end) {
            if (l <= end && a[l] > key)
                largest = l;
            if (r <= end && a[r] > key && a[r] > a[l])
                largest = r;
            if (largest != i) {
                a[i] = a[largest];
            } else
                break;
            i = largest;
            l = (i << 1) + 1;
            r = l + 1;
        }
        a[i] = key;
    }

    private static void buildMaxHeap(int[] a, int start, int end) {
        int size = end - start + 1;
        for (int i = size / 2 - 1; i >= start; i--)
            maxHeapifyIterative(a, i, end);
    }

    private static void heapSort(int[] a, int start, int end) {
        buildMaxHeap(a, start, end);
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.println(a[i]);
            }
        }
        for (int i = end; i > start; i--) {
            int temp = a[i];
            a[i] = a[start];
            a[start] = temp;
            maxHeapifyIterative(a, start, i - 1);
        }
    }

    @Override
    public void sort(int[] a, int start, int end) {
        if (a != null)
            heapSort(a, start, end);
    }
}
