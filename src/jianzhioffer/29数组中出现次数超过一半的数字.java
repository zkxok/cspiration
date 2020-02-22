class Solution {
    // Moore voting algorithm(前提是数组中一定是有元素超过半数的，正好此题是如此)
    // 每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素。
    // 不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e。
    // [1,2,3,3,3]
    // time : O(n) space : O(1)
    public int majorityElement3(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num != res) {
                count--;
            } else count++;
        }
        return res;
    }

    //上面的简洁写法
    public int majorityElement(int[] nums) {
        int count =0;
        int res = Integer.MAX_VALUE;
        for(int num:nums){
            if(count==0) res = num;
            if(num!=res) count--;
            else count++;
        }
        return res;
    }
}
