//判题OJ:
//https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
public class Main38 {
    public List<Integer> findTopk(int[] nums, int k) {
        int len = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        if (len <= 0 || k == 0 || k > len) return res;
        heapSort(nums);
        for (int i = 0; i < k; i++) {//将堆排序后的前k个节点加入数组
            res.add(nums[i]);
        }
        return res;
    }

    // 堆排序
    public void heapSort(int[] arr) {
        int temp;
        initHeap(arr);// 初始化最大堆
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i);// 调整根节点满足最大堆
        }
    }

    // 初始化最大堆
    public void initHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    // 调整最大堆
    public void adjustHeap(int[] arr, int n, int size) {
        int temp = arr[n];
        int child = 2 * n + 1;
        while (child < size) {
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child++;
            }
            if (arr[child] > temp) {
                arr[n] = arr[child];
                n = child;
                child = 2 * n + 1;
            } else {
                break;
            }
        }
        arr[n] = temp;
    }
    
    **********************法2****************************
    public List<Integer> findTopk(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length <= 0 || nums.length < k) return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.poll());
        }
        return res;
    }
    
    **********************************法3**************************************************
    public ArrayList<Integer> findTokSmall(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length < k || k == 0) return res;
        int index = findKthSmall(nums, k);
        for (int i = 0; i <= index; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    public int findKthSmall(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) return pos;
            else if (pos + 1 < k) left = pos + 1;
            else right = pos - 1;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
