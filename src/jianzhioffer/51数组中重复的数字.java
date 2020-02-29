class Solution {
    
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
            if(count[nums[i]] > 1) return nums[i];
        }
        return -1;
    }
    /*********************************/
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
