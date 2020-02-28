十大经典排序算法:
https://www.runoob.com/w3cnote/ten-sorting-algorithm.html
https://github.com/francistao/LearningNotes/blob/master/Part3/Algorithm/Sort/%E9%9D%A2%E8%AF%95%E4%B8%AD%E7%9A%84%2010%20%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93.md
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
