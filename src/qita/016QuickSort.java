public class Main {
//OJ地址:https://www.nowcoder.com/questionTerminal/3385982ae71d4a1ca8bf3d03614c0325
	public void quickSort(int nums[], int left, int right) {
		if (left >= right) return;//left>right肯定不行,left=right时，只有一个数也没必要继续排序
		int pos = partition(nums, left, right);
		quickSort(nums, left, pos - 1);//非递归要用栈来模拟,那还是算了吧
		quickSort(nums, pos + 1, right);
	}

	public int partition(int nums[], int left, int right) {
		int pivot = nums[left];
		int l = left + 1;
		int r = right;
		while (l <= r) {//算上left至少两个数
			if (nums[l] > pivot && nums[r] < pivot) {
				swap(nums, l++, r--);
			}
			if (nums[l] <= pivot) l++;
			if (nums[r] >= pivot) r--;
		}
		swap(nums, left, r);
		return r;
	}

	public void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
