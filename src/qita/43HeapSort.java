import java.util.*;

public class Main {
     //测试用
     //测试OJ:https://www.nowcoder.com/questionTerminal/3385982ae71d4a1ca8bf3d03614c0325
    /**public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int number = Integer.parseInt(cin.nextLine());
        String[] data = cin.nextLine().split(" ");
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = Integer.parseInt(data[i]);
        }
        new Main().heapSort(array);
        for (int i = 0; i < number; i++) {
            if (i != number - 1)
                System.out.print(array[i] + " ");
            else
                System.out.print(array[i]);
        }
    }*/

    // 堆排序
    public void heapSort(int[] arr) {
        initHeap(arr);// //构建大顶堆, 从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = arr.length - 1; i > 0; i--) {
            // 调整堆结构+交换堆顶元素与末尾元素
            // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
            //将堆顶记录和当前未经排序子序列的最后一个记录交换
            swap(arr, 0, i);// 将堆顶元素与末尾元素进行交换,交换后最后一个元素为最大
            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            adjustHeap(arr, 0, i);// 调整根节点满足最大堆,
        }
    }

    // 初始化最大堆
    public void initHeap(int[] arr) {
        // 从第一个非叶子结点从下至上，从右至左调整结构
         //依次以索引arr.length / 2 - 1到0的元素为堆顶（根节点）,调整大顶堆,
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }
    //以i为根节点，调整最大堆
    // 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
    public void adjustHeap(int[] arr, int i, int size) {//i是堆顶坐标,size是数组元素个数，不是坐标
        int temp = arr[i];// 先取出当前元素i////根节点
        int child = 2 * i + 1;// 左子节点,从i结点的左子结点开始，也就是2i+1处开始
        while (child < size) {// 有左子结点
            if (child + 1 < size && arr[child + 1] > arr[child]) {// 且有右子节点,如果左子结点小于右子结点，child指向右子结点
                child++;
            }
            // 如果父节点小于孩子结点，则需要交换
            // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[child] > temp) {// 这里的arr[child] 左右子节点中较大的那个子节点//子节点>根节点
                arr[i] = arr[child];//子节点值=父节点值
                i = child;//索引变成子节点的,向下遍历到子节点
                child = 2 * i + 1;//child变成i的左子节点继续遍历//这里的child就是子节点的子节点了
            } else {
                break;// 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = temp;// 将temp值放到最终的位置
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
