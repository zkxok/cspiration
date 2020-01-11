package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindMinimuminRotatedSortedArray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FindMinimuminRotatedSortedArray {
    /**
     * 153. Find Minimum in Rotated Sorted Array
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     4 5 6 7 0 1 2

     4 5 6 0 1 2 3

     2 1

     * time : O(logn)
     * space : O(1);
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {//注意还要考虑完全正序和完全逆序的情况，我的两种错误写法就是没有考虑这点
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {// 不可能会有==的情况(当然加上=也不会报错),因为参与的最少是3个数,而且没有重复数
                end = mid;// [1,2,3],这里一定是end=mid,不能是end=mid-1,(如[3,1,2]情况)
            } else {// nums[mid]>=nums[end],[2,3,1],
                start = mid + 1;// 这里最好+1，不+1也不报错
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
    
	//这个是我写的错误答案，要注意
    /**public int findMin2(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start+1<end){
            int mid = (end-start)/2 +start;
            if(nums[mid]>nums[start]){//要注意[1,2,3]的情况
                start = mid;
            } else if(nums[mid]<nums[end]) {
                end = mid;
            } 
        }
        if(nums[start]<nums[end]) return nums[start];
        else return nums[end];
    }**/
	
    //我写的错误答案2：例如：[4,5,6,7,0,1,2]
    /**
    public int findMin(int nums[]) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[start]) {// start->mid递增
                end = mid;
            } else {// mid->end递增
                start = mid + 1;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
   */
  
}
