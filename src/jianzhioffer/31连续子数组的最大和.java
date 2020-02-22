class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int sum = nums[0];
        int maxSum =nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum>0){
                sum+=nums[i];
            }else{
                sum=nums[i];
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }


    //最优解法
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum =  nums[0];
        for(int i= 1;i<nums.length;i++){
            if(sum>0){
                sum=sum+nums[i];
            }else{
                sum = nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }
    //上面写法的另一种形式
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;//要考虑会有负数
        int sum = 0;
        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else{
                sum = num;
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
