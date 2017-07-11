/**
 * Created by babooloon on 2017/7/11.
 * Email: nickyangcchs@hotmail.com
 * Project: SortingAlgorithm
 */
public class MergeSort implements Sorting {
    private static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (r + p) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(a, p, L, 0, n1);
        System.arraycopy(a, q + 1, R, 0, n2);
        int i = 0;
        int j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (L[i] < R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        }
        while (i < n1)
            a[k++] = L[i++];
        while (j < n2)
            a[k++] = R[j++];
    }

    @Override
    public void sort(int[] a, int start, int end) {
        mergeSort(a, start, end);
    }
}
