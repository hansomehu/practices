package interview150.matrix;

import java.util.ArrayList;
import java.util.List;

public class S54_SpiralMatrix {
    /*
    https://leetcode.cn/problems/spiral-matrix/
    按层模拟，对于很多矩阵问题都可以通过找到转移方程来进行层次模拟
     */
    public List<Integer> solution(int[][] matrix){
        List<Integer> res = new ArrayList<>();

        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom){
            for (int column = left; column <= right; column++){
                res.add(matrix[top][column]);
            }
            for (int row = top; row <= bottom; row++){
                res.add(matrix[row][right]);
            }
            if (left < right && top > bottom){
                for (int column = right - 1; column > left; column--){
                    res.add(matrix[bottom][column]);
                }
                for (int row = bottom - 1; row < top; row--){
                    res.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }
}
