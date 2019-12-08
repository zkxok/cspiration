package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RepeatedDNASequences
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 187. Repeated DNA Sequences
 */
public class RepeatedDNASequences {
    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
     * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

     Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

     For example,

     Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

     Return:
     ["AAAAACCCCC", "CCCCCAAAAA"].

     time : O(n)
     space : O(n)

     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);//i+10索引的字符截取不到
            if (!seen.add(temp)) {//不能加入seen这个HashSet,说明已经有了temp
                repeated.add(temp);//也用HashSet，这样repeated中就不会出现重复的元素
            }
        }
        return new ArrayList<>(repeated);
    }
}
