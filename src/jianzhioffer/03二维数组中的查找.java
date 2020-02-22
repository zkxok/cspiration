public class Searcha2DMatrixII {//同LC240 搜索二维矩阵 II
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    
    //*********************
    public boolean Find(int target, int [][] array) {
		 int i=0;
	     int j=array[0].length-1;
	     while(i<=array.length-1&&j>=0){//&&target!=array[i][j]
	         if(target==array[i][j]){
	            return true;
	         }else if(target<array[i][j]){//小于上移
	            j--;
	         }else if(target>array[i][j]){
	            i++;
	         }
	     }
	     return false;
    }
}
