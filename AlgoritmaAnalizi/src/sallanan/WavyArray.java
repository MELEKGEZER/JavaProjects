
package sallanan;

public class WavyArray {
    public static void makeWavy(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i += 2) {
            // A[i] ≤ A[i + 1] kontrolü
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
            // A[i] ≥ A[i - 1] kontrolü
            if (i - 1 >= 0 && arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] B = {3, 5, 2, 1, 6, 4, 7};
        makeWavy(B);
        for (int num : B) {
            System.out.print(num + " ");
        }
        // Örnek çıktı: 3 5 1 2 4 6 7
    }
}

