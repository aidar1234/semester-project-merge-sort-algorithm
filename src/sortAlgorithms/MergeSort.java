package sortAlgorithms;

public class MergeSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr);
    }

    private static void mergeSort(int[] arr) {
        if (arr.length == 1) {
            return;
        }

        int length = arr.length;
        int mid = length / 2;

        int[] leftArr = new int[mid];
        arrCopy(arr, 0, leftArr, leftArr.length);

        int[] rightArr = new int[length - mid];
        arrCopy(arr, mid, rightArr, rightArr.length);

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    }

    private static void merge(int arr[], int[] leftArr, int[] rightArr) {

        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }

    private static void arrCopy(int[] source, int srcPos, int[] dest, int n) {
        for (int i = srcPos, j = 0; j < n; i++, j++) {
            dest[j] = source[i];
        }
    }
}
