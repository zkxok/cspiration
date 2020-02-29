public class Solution {
    public int InversePairs(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        return mergeSort(array, 0, array.length - 1);
    }
    public int mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int leftNum = mergeSort(arr, low, mid);// 左
        int rightNum = mergeSort(arr, mid + 1, high);// 右
        int count = merge(arr, low, mid, high);
        return (leftNum + rightNum + count)%1000000007;
    }
 
    public int merge(int[] arr, int low, int mid, int high) {
        int i = mid;// 左指针
        int j = high; // 右指针
        int k = high - low;
        int temp[] = new int[high - low + 1];// 临时数组
        int count = 0;
        while (i >= low && j > mid) {
            if (arr[i] > arr[j]) {
                temp[k--] = arr[i--];
                count += (j - mid);
                if (count > 1000000007)// 数值过大求余
                {
                    count %= 1000000007;
                }
            } else {
                temp[k--] = arr[j--];
            }
        }
        while (i >= low) {
            temp[k--] = arr[i--];
        }
        while (j > mid) {
            temp[k--] = arr[j--];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + low] = temp[k2];
        }
        return count;
    }
 
}
