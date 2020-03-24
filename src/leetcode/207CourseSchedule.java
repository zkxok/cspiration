package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CourseSchedule
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 207. Course Schedule
 */
public class CourseSchedule {

    /**
     * There are a total of n courses you have to take, labeled from 0 to n - 1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
     which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

     For example:

     2, [[1,0]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

     2, [[1,0],[0,1]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0,
     and to take course 0 you should also have finished course 1. So it is impossible.

     3-  0 - 1
         \   /
           2

     入度 = 0

     0 : 1
     1 : 1
     2 : 1

     queue : 2

     pre : 2

     res = 3


     time : O(V + E)
     space : O(n)

     * @param numCourses
     * @param prerequisites
     * @return
     */
     
    // BFS检测有向图是否有环==检测死锁
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int res = numCourses;
        //计算所有节点pair[0]的入度
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            //将入度为0的加入队列
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            //将每一个元素(入度为0的)出队列,当图中所有元素都入队列后且都出队列，那么没有环
            int pre = queue.poll();
            res--;//记录出队列的次数，当所有元素都入队列且出队列，那么res==0,没有环，否则有环
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {//找到入度为0节点的邻接节点
                    indegree[pair[0]]--;//将其邻接节点入度-1
                    if (indegree[pair[0]] == 0) {//入度-1后又有可能入度变成0，将入度为0的加入队列
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        //res==0，说明所有的元素都入过队列，且出了队列
        return res == 0;
    }
}
