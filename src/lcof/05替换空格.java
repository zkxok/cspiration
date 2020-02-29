public class Solution {
   public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        char[] ch = str.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            String s = String.valueOf(ch[i]);
            if (s.equals(" ")){
                sb.append("%20");
            }else{
               sb.append(s);
            }
             
        }
        return sb.toString();
    }
}
