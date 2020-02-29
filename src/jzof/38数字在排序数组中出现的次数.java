class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int start = findFirst(nums, target);
        if (start == -1) return 0;
        int end = findLast(nums, target);
        return end - start + 1;
    }

    public int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {//如果只有两个数，直接判断就好,这里是将范围缩小至两个数
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) return start;//避免刚好只有两个数时的问题,比如[2,2],2
        if (nums[end] == target) return end;
        return -1;
    }

    public int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;//避免刚好只有两个数时的问题,比如[2,2],2
        if (nums[start] == target) return start;
        return -1;
    }
}
