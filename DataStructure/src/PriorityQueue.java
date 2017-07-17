/**
 * Created by babooloon on 2017/7/17.
 * Email: nickyangcchs@hotmail.com
 * Project: Data Structure
 */
public class PriorityQueue {
    private int[] a = new int[10];
    private int size = 0;

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            if (i != this.size - 1)
                sb.append(this.a[i]).append(", ");
            else
                sb.append(this.a[i]);
        }
        return sb.toString();
    }
    public int heapMax() {
        return a[0];
    }

    public int extractMax() {
        if (size < 1) {
            System.err.println("heap underflow");
        }
        int max = a[0];
        a[0] = a[size-- - 1];
        return max;
    }

    private void heapIncreaseKey(int i, int key) {
        if (key < a[i]) {
            System.err.println("new key is smaller than current key.");
        }
        a[i] = key;
        while (i > 0 && a[i / 2] < key) {
            a[i] = a[i / 2];
            i = i / 2;
        }
        a[i] = key;
    }

    public void maxHeapInsert(int key) {
        if (size == a.length) {
            int[] temp = new int[2 * size];
            System.arraycopy(a, 0, temp, 0, a.length);
            a = temp;
        }
        a[++size] = Integer.MIN_VALUE;
        heapIncreaseKey(size - 1, key);
    }

    public void maxHeapDelete(int i) {
        if (i < 0 || i >= size) {
            System.err.println("index out of range.");
        } else if (a[size - 1] > a[i]) {
            a[i] = a[--size];
            heapIncreaseKey(i, a[size]);
        } else if (a[size - 1] < a[i]) {
            a[i] = a[--size];
            maxHeapify(i, size - 1);
        }
    }

    private void maxHeapify(int i, int end) {
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
            maxHeapify(largest, end);
        }
    }
}
