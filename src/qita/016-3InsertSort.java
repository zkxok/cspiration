//插入排序:Time:O(n^2),Space:(1) ；最好(全部有序)Time:O(n)；最坏(全部逆序)Time:O(n^2),稳定
//https://www.nowcoder.com/questionTerminal/2e06286d2ec14e318f5f8eb16683678a
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
