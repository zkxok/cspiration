class Solution {
	//这里是有序的,LC是无序的
    public int missingNumber(int[] nums) {
        int low=0,high=nums.length;
        while(low<high){//至少两个数
            int mid=(low+high)>>1;
            if(nums[mid]!=mid) high=mid;
            else low=mid+1;
        }
        return low;
    }
}