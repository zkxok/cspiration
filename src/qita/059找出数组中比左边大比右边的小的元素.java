//2018腾讯内部调岗面试试题3——找出数组中比左边大比右边的小的元素
//题解: https://cloud.tencent.com/developer/article/1176017
//https://cloud.tencent.com/developer/article/1176017
public class Main59 {
    public void findElements(int[] data) {
        int len = data.length;
        // 从右往左，寻找每个位置及其之后的最小数
        //例如:rightMin[i+1],存储的是倒数(从右向左数),i+1索引到数组末尾范围内最小的数[i+1,nums.length-1]
        int rightMin[] = new int[len];
        int r_min = data[len - 1];
        for (int i = len - 1; i >= 0; --i) {
            if (data[i] < r_min) {
                r_min = data[i];
            }
            rightMin[i] = r_min;
        }

        // 从左往右，寻找比左边大且比右边小的数
        int l_max = data[0];
        for (int i = 0; i < len - 1; ++i) {
            if (data[i] > l_max) {//比左边大
                l_max = data[i];
                if (data[i] < rightMin[i + 1]) {//比右边小
                    System.out.println(data[i]);
                }
            }
        }
    }
}
