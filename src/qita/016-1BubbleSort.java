    public static void bubbleSort(long[] arr) {
        int n = arr.length;
        boolean exchange = true;
        long temp;
        for (int i = 0; i < n - 1; i++) {
            exchange = false;
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    exchange=true;
                }
            }
            if (!exchange) return;
        }
    }
