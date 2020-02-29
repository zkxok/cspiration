public class Solution {
    public String PrintMinNumber(int [] nums) {
        if(nums==null || nums.length==0) return "";
        String res[] = new String[nums.length]; 
        for(int i=0;i<nums.length;i++){
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s: res){
            sb.append(s);
        }
        return sb.toString();
    }
}
