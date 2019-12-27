public class PrintZigZigMatrix {// 之字形打印矩阵
	public static List<Integer> printMatrix(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 0) {// 奇数行
					res.add(matrix[i][j]);
				} else {// 偶数行
					res.add(matrix[i][n - 1 - j]);
				}
			}
		}
		return res;
	}

	public int[] printMatrix2(int[][] matrix, int m, int n) {
		int[] res = new int[m * n];
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 0) {// 奇数行
					res[count++] = matrix[i][j];
				} else {// 偶数行
					res[count++] = matrix[i][n - 1 - j];
				}
			}
		}
		return res;
	}
	
}
