十大经典排序算法:
https://www.runoob.com/w3cnote/ten-sorting-algorithm.html
//冒泡排序:Time:O(n^2),Space:(1) ,最好Time:O(n),最坏Time:O(n^2) 稳定  
public static void bubbleSort(long[] arr) {
    int n = arr.length;
    boolean exchange = true;
    long temp;
    for (int i = 0; i < n - 1; i++) {
        exchange = false;
        for (int j = n - 1; j > i; j--) {
            if (arr[j - 1] > arr[j]) {
                temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                exchange=true;
            }
        }
        if (!exchange) return;
    }
 }
