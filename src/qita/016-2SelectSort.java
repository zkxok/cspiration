public static void selectSort(long arr[]) {
		int minIndex;
		long temp;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}
