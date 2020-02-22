class Solution {

    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 != 0) {// 奇数
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {// 偶数
                end--;
            }
            if (start < end) {
                swap(nums, start, end);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int sow) {
        int tmp = nums[i];
        nums[i] = nums[sow];
        nums[sow] = tmp;
    }

}
