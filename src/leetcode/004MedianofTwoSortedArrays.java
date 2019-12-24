package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MedianofTwoSortedArrays
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 4. Median of Two Sorted Arrays
 */
public class MedianofTwoSortedArrays {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.

     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

     Example 1:
     nums1 = [1, 3]
     nums2 = [2]

     The median is 2.0
     Example 2:
     nums1 = [1, 2]
     nums2 = [3, 4]

     The median is (2 + 3)/2 = 2.5


     O(log(min(m,n)))
     题解:https://www.bilibili.com/video/av62872193?from=search&seid=228840549916769309

     参考博客：http://blog.csdn.net/chen_xinjia/article/details/69258706

     index: 0	1	2	3	4	5
               L1   R1
     num1:	3 	5 |	8 	9    	      4  cut1：左有几个元素
     num2:	1	2 	7 | 10  11  12     6  cut2：左有几个元素
                    L2  R2

     num3:  1 2 3 5 7 | 8 9 10 11 12

     num3 -> num1 + num2 -> num1

     L1 <= R2
     L2 <= R1

     (cutL, cutR)

     L1 > R2 cut1 <<  (cutL, cut1 - 1)
     L2 > R1 cut2 >>  (cut1 + 1, cutR)

     index: 0	1	2	3	4	5
               L1   R1
     num1:	3 	5 |	8 	9   |	      4  cut1：左有几个元素
     num2:	1	2 	7 | 10  11  12     6  cut2：左有几个元素
                    L2  R2

     num3:  1 2 3 5 7 | 8 9 10 11 12

     int cut1 = 2;
     int cut2 = 3;
     int cutL = 0;
     int cutR = 4;


     time : O(log(min(m,n)))
     space : O(1)

     * @param nums1
     * @param nums2
     * @return
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                } else {
                    R1 = (R1 < R2) ? R1 : R2;
                    return R1;
                }
            }
        }
        return -1;
    }
    
    
    
    **********上面的方案加注释版*******************
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {//保证nums1的长度一定是小于等于nums2的长度的
			return findMedianSortedArrays(nums2, nums1);
		}
		int len = nums1.length + nums2.length;
		int cut1 = 0;//数组1的切割位mid
		int cut2 = 0;//数组2的切割位
		//因为需要进行二分查找
		int cutL = 0;//数组1切割后的start
		int cutR = nums1.length;//数组1切割后的end
		while (cut1 <= nums1.length) {
			cut1 = (cutR - cutL) / 2 + cutL;//对数组1进行二分查找，每次从二分的中间位置cut1开始切割
			cut2 = len / 2 - cut1;//根据数组1的切割位置cut1,来计算数组2的切割位置cut2
			double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
			double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
			double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
			double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
			//三种情况
			if (L1 > R2) {
				cutR = cut1 - 1;
			} else if (L2 > R1) {
				cutL = cut1 + 1;
			} else {//L1<=R2 L2<=R1,cut1的位置是正确的
				if (len % 2 == 0) {//长度是偶数,那么中位数是两数平均(L1,L2,R1,R2四个数中，处于中间大小的两个数的平均值)
					L1 = L1 > L2 ? L1 : L2;
					R1 = R1 < R2 ? R1 : R2;
					return (L1 + R1) / 2;
				} else {//长度是奇数时,那么中位数是cu1位的数R1=nums1[cu1]或cut2位的数R2=nums2[cut2]中较小的那个
					R1 = (R1 < R2) ? R1 : R2;
					return R1;
				}
			}
		}
		return -1;
	}
}
