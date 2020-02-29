public class Solution {
    public int[] constructArr(int[] A) {
        if (A == null || A.length <= 0) return new int[]{};
        int B[] = new int[A.length];
        B[0] = 1;
        // 计算下(左)三角部分//规律:B[i]=B[i-1]*A[i-1]
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;// temp值计算的是A[n-1]*A[n-2]...*A[1]的累加值
        // 计算上(右)三角部分//规律:B[i]=B[i+1]*A[i+1]
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }

    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= a[i], i++) /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--) /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
}
