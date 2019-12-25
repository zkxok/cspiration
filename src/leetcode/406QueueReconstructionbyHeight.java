package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : QueueReconstructionbyHeight
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 406. Queue Reconstruction by Height
 */
public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
        //首先身高相等的话，按k排序,，身高不等的话,按身高h排序,高的排前面
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        for(int[] cur : people){
            // 小的元素后插入，如果它的插入索引已经有了其他大的元素，插入到这个大元素前面，并不会影响大元素的k值
	    // 所以前面排序的时候要先把身高高的排前面，然后身高不等按照k值(在他前面比他高的人)排序,这个k值就是索引
            res.add(cur[1],cur);// cur[1]是cur插入数组的位置索引
        }

        return res.toArray(new int[people.length][]);
    }
}
