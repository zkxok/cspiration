package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CourseScheduleII
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 210. Course Schedule II
 */
public class CourseScheduleII {
    /**
     * There are a total of n courses you have to take, labeled from 0 to n - 1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
     which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, return the resing of courses you should
     take to finish all courses.

     There may be multiple correct ress, you just need to return one of them. If it is impossible to finish all courses,
     return an empty array.

     For example:

     2, [[1,0]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course res
     is [0,1]

     4, [[1,0],[2,0],[3,1],[3,2]]
     There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
     Both courses 1 and 2 should be taken after you finished course 0. So one correct course res is [0,1,2,3].
     Another correct resing is[0,2,1,3].


       -> 1 ->
     0         3
       -> 2 ->


     入度 = 0 => BFS

     0 : 0
     1 : 0
     2 : 0
     3 : 0

     queue : 3
     res : 0,1,2,3

     time : O(V + E)
     space : O(n)

     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int k = 0;
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }
        return (k == numCourses) ? res : new int[0];
    }
    ***************************************************
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int res[] = new int[numCourses];
        int indegree[] = new int[numCourses];
        //int res = numCourses;
        for(int[] pair : prerequisites){//遍历到的pair[0]是有入度的,pair[1]是它的先驱节点
            indegree[pair[0]]++;//计算每门课程的入度
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        int index=0;
        while(!queue.isEmpty()){
            int pre = queue.poll();//队列里的都是入度为0的节点
            res[index++]=pre;
            for(int[] pair:prerequisites){
                if(pair[1]==pre){
                    indegree[pair[0]]--;//入度消除
                    //如果队列中没有了入度为0的节点了,且还有元素没有没有进入过队列,res最后不等于0,那么就是有环,有环就不能完成课程
                    if(indegree[pair[0]]==0) queue.offer(pair[0]);
                }
            }
        }
        return index==res.length?res:new int[]{};
    }
    
    
    *****************************************
    public int[] findOrder3(int numCourses, int[][] prerequisites) {
        int res[] = new int[numCourses];
        int indegree[] = new int[numCourses];
        for(int[] pair : prerequisites){//遍历到的pair[0]是有入度的,pair[1]是它的先驱节点
            indegree[pair[0]]++;//计算每门课程的入度
        }
        int index=0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) {
                queue.offer(i);//这里也有入队列的,要么在入队列时加入res,要么在出队列时加入res
                res[index++]=i;
            }
        }
       
        while(!queue.isEmpty()){
            int pre = queue.poll();//队列里的都是入度为0的节点
            for(int[] pair:prerequisites){
                if(pair[1]==pre){
                    indegree[pair[0]]--;//入度消除
                    //如果队列中没有了入度为0的节点了,且还有元素没有没有进入过队列,res最后不等于0,那么就是有环,有环就不能完成课程
                    if(indegree[pair[0]]==0){
                        queue.offer(pair[0]);
                        res[index++]=pair[0];
                    } 
                }
            }
        }
        return index==res.length?res:new int[]{};
    }
}
