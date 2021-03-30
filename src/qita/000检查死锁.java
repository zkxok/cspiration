package test;

import java.util.*;

//https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
//https://github.com/scarcoco/projx/issues/38
public class Main {


    public static void main(String[] args) {
        MyThread threads[] = new MyThread[3];
        MyThread t0 = new MyThread();
        t0.holdingid = new int[]{0, 1, 2, 3};
        t0.waitingid = 4;

        MyThread t1 = new MyThread();
        t1.holdingid = new int[]{4, 5, 6};
        t1.waitingid = 7;

        MyThread t2 = new MyThread();
        t2.holdingid = new int[]{7, 8};
        t2.waitingid = 4;
        threads[0] = t0;
        threads[1] = t1;
        threads[2] = t2;
        boolean isDeadLock = isDeadLock(threads);
        System.out.println("isDeadLock:" + isDeadLock);
    }

    //检查是否死锁
    static boolean isDeadLock(MyThread threads[]) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<int[]> linkedList = new LinkedList();
        for (int i = 0; i < threads.length; i++) {
            int hidArr[] = threads[i].holdingid;
            int wid = threads[i].waitingid;
            set.add(wid);
            for (int j = 0; j < hidArr.length; j++) {
                set.add(hidArr[j]);
                int arr[] = new int[2];
                arr[0] = hidArr[j];
                arr[1] = wid;
                linkedList.add(arr);
            }
        }
        int[] matrix[] = new int[linkedList.size()][2];
        int count = 0;
        System.out.println("matrix:" + matrix.length);
        for (int arr[] : linkedList) {
            matrix[count] = arr;
            count++;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println("---------");

        }
        System.out.println("set.size:" + set.size());
        return !canFinish(set.size(), matrix);
    }

    static class MyThread {
        int waitingid;
        int holdingid[];
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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
        //res==0,说明有向图无环,可以完成选修课程
        return res == 0;
    }

}
