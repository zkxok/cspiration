class Solution {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10, n);
        int[] ans = new int[max - 1];
        for(int i = 1 ; i <= max - 1 ; i++){
            ans[i - 1] = i;
        }
        return ans;
    }
}
