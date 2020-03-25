package test;

import java.util.*;

//https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
public class TestMain {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.holdingid = new int[]{1,2,3};
		t1.waitingid = 4;
		MyThread t2 = new MyThread();
		t2.holdingid = new int[]{4,5,6};
		t2.waitingid = 7;
		MyThread t3 = new MyThread();
		t3.holdingid = new int[]{7,8,9};
		t3.waitingid = 11;
		MyThread t4 = new MyThread();
		t4.holdingid = new int[]{10,11,12};
		t4.waitingid = 15;
		MyThread t5 = new MyThread();
		t5.holdingid = new int[]{13,14,15};
		t5.waitingid = 3;
		MyThread thread[] = { t1, t2, t3, t4, t5 };
		System.out.println(isDeadLock(thread));
	}

	public static class MyThread {
		int waitingid;
		int holdingid[];
	}

	public static class ThreadId {
		int intId;
		String stringId;
		boolean isIntId;

		public ThreadId(String stringId) {
			this.stringId = stringId;
			this.isIntId = false;
		}

		public ThreadId(int intId) {
			this.intId = intId;
			this.isIntId = true;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof ThreadId))
				return false;
			ThreadId threadId = (ThreadId) o;
			return intId == threadId.intId && isIntId == threadId.isIntId && stringId.equals(threadId.stringId);
		}

		@Override
		public int hashCode() {
			return Objects.hash(intId, stringId, isIntId);
		}
	}

	// 检查是否死锁
	static boolean isDeadLock(MyThread threads[]) {
		Map<ThreadId, Set<ThreadId>> map = createMap(threads);
		Map<ThreadId, Integer> threadIdIndexMap = getAllThreadIdIndexMap(map);
		Map<Integer, ThreadId> indexThreadIdMap = getAllIndexThreadIdMap(map);
		int numCourses = map.size();
		int[][] prerequisites = new int[numCourses][];

		for (int i = 0; i < numCourses; i++) {
			int[] lines = null;
			ThreadId threadId = indexThreadIdMap.get(i);
			Set<ThreadId> fromSet = map.get(threadId);
			lines = new int[fromSet.size()];

			int index = 0;
			for (ThreadId from : fromSet) {
				lines[index] = threadIdIndexMap.get(from);
				index++;
			}
			prerequisites[i] = lines;
		}
		return canFinish(numCourses, prerequisites);
	}

	public static Map<ThreadId, Integer> getAllThreadIdIndexMap(Map<ThreadId, Set<ThreadId>> map) {
		Map<ThreadId, Integer> allThreadIdIndexMap = new HashMap<>();
		int index = 0;
		for (ThreadId threadId : map.keySet()) {
			allThreadIdIndexMap.put(threadId, index);
			index++;
		}
		return allThreadIdIndexMap;
	}

	public static Map<Integer, ThreadId> getAllIndexThreadIdMap(Map<ThreadId, Set<ThreadId>> map) {
		Map<Integer, ThreadId> allThreadIdIndexMap = new HashMap<>();
		int index = 0;
		for (ThreadId threadId : map.keySet()) {
			allThreadIdIndexMap.put(index, threadId);
			index++;
		}
		return allThreadIdIndexMap;
	}

	public static Map<ThreadId, Set<ThreadId>> createMap(MyThread[] threads) {
		Map<ThreadId, Set<ThreadId>> map = new HashMap<>();
		for (int i = 0; i < threads.length; i++) {
			ThreadId from = new ThreadId(String.valueOf(i));
			ThreadId to = new ThreadId(threads[i].waitingid);
			Set<ThreadId> lineList = map.get(to);
			if (lineList == null) {
				lineList = new HashSet<>();
			}
			lineList.add(from);

			map.put(to, lineList);
			for (int j = 0; j < threads[i].holdingid.length; j++) {
				ThreadId fromInner = new ThreadId(threads[i].holdingid[j]);
				ThreadId toInner = fromInner;
				Set<ThreadId> lineListInner = map.get(toInner);
				if (lineListInner == null) {
					lineListInner = new HashSet<>();
				}
				lineListInner.add(fromInner);
				map.put(toInner, lineListInner);
			}
		}
		return map;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] in = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : prerequisites) {
			graph.get(edge[1]).add(edge[0]);
			in[edge[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (in[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int i = queue.poll();
			for (int a : graph.get(i)) {
				in[a]--;
				if (in[a] == 0)
					queue.add(a);
			}
		}

		for (int i = 0; i < numCourses; i++)
			if (in[i] != 0)
				return false;
		return true;
	}
}
