class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){//要考虑只有一个数的情况
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
