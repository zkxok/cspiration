public class Solution {

    public String[] permutation(String s) {
        // 直接用string[] 无法判断个数
        ArrayList<String> list = new ArrayList<>();
        helper(s.toCharArray(), 0, list);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void helper(char[] ch, int i, ArrayList<String> list) {
        if (i == ch.length) {
            list.add(String.valueOf(ch));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < ch.length; j++) {
            if (j == i || !set.contains(ch[j])) {
                set.add(ch[j]);
                swap(ch, i, j);
                helper(ch, i + 1, list);
                swap(ch, j, i);
            }
        }

    }

    public void swap(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

}
