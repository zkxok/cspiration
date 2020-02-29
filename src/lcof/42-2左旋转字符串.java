class Solution {
    public String reverseLeftWords(String s, int n) {
        char c[] = s.toCharArray();
        n = n % c.length;
        reverse(c,0,n-1);
        reverse(c,n,c.length-1);
        reverse(c,0,c.length-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<c.length;i++){
            sb.append(c[i]);
        }
        return sb.toString();
    }

    public void reverse(char c[],int i,int j){
        while(i<j){
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
            // i++;
            // j--;
        }
    }

}
