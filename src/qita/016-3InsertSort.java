
public static void insertSort(long arr[]) {
    long temp;
    for (int i = 1; i < arr.length; i++) {
        temp = arr[i];
        int j = i;
        while (j > 0 && arr[j - 1] > temp) {
            arr[j] = arr[j - 1];
            j--;
        }
        if (temp != arr[j])
            arr[j] = temp;
    }
}
