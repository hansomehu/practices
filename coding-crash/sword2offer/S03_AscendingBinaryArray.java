package sword2offer;

public class S03_AscendingBinaryArray {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 思路：从右上角开始用二分法进行查找：比对比元素大就往下走，否则往左走
     */

    public boolean find(int[][] matrix, int target) {
        if (matrix == null)
            return false;

        int row = 0;
        int column = matrix[0].length - 1;

        while ((column >= 0) && (row <= matrix.length - 1)) {
            if (matrix[row][column] == target)
                return true;
            if (matrix[row][column] > target) {
                // one step leftward, find a smaller value
                column--;
            }
            if (matrix[row][column] < target) {
                // one step downward, find a bigger value
                row++;
            }

        }

        return false;
    }

}
