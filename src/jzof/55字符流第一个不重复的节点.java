public class Solution {
    int count[] = new int[256];
    int index = 0;// 出现的索引

    // Insert one char from stringstream
    public void Insert(char ch) {
        if (count[ch] == 0) {// 第一次出现(索引增1)
            count[ch] = ++index;
        } else {// 不是第一次出现的赋值为-1,做标记
            count[ch] = -1;
        }
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; i++) {
            // count[i] != 0:i出现了,且count[i] != -1:i只出现1次
            if (count[i] != 0 && count[i] != -1 && count[i] < minIndex) {
                ch = (char) i;
                minIndex = count[i];
            }
        }
        return ch;
    }
}
