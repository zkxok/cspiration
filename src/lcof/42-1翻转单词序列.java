public String reverseWords(String s) {
    if (s == null || s.length() == 0) return s;
    StringBuilder sb = new StringBuilder();
    String[] words = s.trim().split("\\s+");
    for (int i = words.length - 1; i >=0; i--) {
        sb.append(words[i] + " ");
    }
    return sb.toString().trim();
}

public void reverseWords(char[] s) {
    reverse(s,0,s.length-1);
    int r = 0;
    while(r<s.length){
        int l=r;
        while(r<s.length&&s[r]!=' '){
            r++;
        }
        reverse(s,l,r-1);//r-1,此时s[r]==' ',所以需要r-1
        r++;
    }
}

private void reverse(char[] s,int i,int j){
    while(i<j){//至少有两个数
        char temp = s[i];
        s[i++]=s[j];
        s[j--]=temp;
    }
}
