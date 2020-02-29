//OJ地址:https://www.nowcoder.com/questionTerminal/3385982ae71d4a1ca8bf3d03614c0325
public class QuickSort {
    //平均/最好Time:O(nlogn),Space:O(logn).最坏Time:O(n^2),不稳定
    public void quickSort(int nums[], int left, int right) {
        if (left >= right) return;// left>right肯定不行,left=right时，只有一个数也没必要继续排序
        int pos = partition(nums, left, right);
        quickSort(nums, left, pos - 1);// 非递归要用栈来模拟,那还是算了吧
        quickSort(nums, pos + 1, right);
    }
    public int partition(int nums[], int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {// 算上left至少两个数
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }//r<l时退出循环,此时r处的元素比基准点pivot(nums[left])小
        swap(nums, left, r);
        return r;
    }
    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//OJ地址:https://www.nowcoder.com/questionTerminal/3385982ae71d4a1ca8bf3d03614c0325//
//OJ辅助代码
// import java.util.Scanner;
// public class Main {
//     public static void main(String[] args) {
//         Scanner cin = new Scanner(System.in);
//         int number = Integer.parseInt(cin.nextLine());
//         String[] data = cin.nextLine().split(" ");
//         int[] array = new int[number];
//         for (int i = 0; i < number; i++) {
//             array[i] = Integer.parseInt(data[i]);
//         }
//         quickSort(array, 0, number - 1);
//         for (int i = 0; i < number; i++) {
//             if (i != number - 1)
//                 System.out.print(array[i] + " ");
//             else
//                 System.out.print(array[i]);
//         }
//     }
// }
