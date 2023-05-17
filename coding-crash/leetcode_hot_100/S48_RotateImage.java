package leetcode_hot_100;

/*
https://leetcode.cn/problems/rotate-image/
解题思路，进行一次二维矩阵的遍历，在抽象上将矩阵分为四块，A点旋转到它的目标B点，B点旋转到C点，C点旋转到D点，逐个进行替换
其中A点的数据用一个temp来保存
 */
public class S48_RotateImage {
    private int[][] solution(int[][] img){

        int n = img.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) { // n+1 means to adapt both odd and even dimension array
                int temp = img[i][j];
                img[i][j] = img[n - j - 1][i];
                img[n - j - 1][i] = img[n - i - 1][n - j - 1];
                img[n - i - 1][n - j - 1] = img[j][n - i -1];
                img[j][n - i -1] = temp;
            }
        }

        return img;
    }
}
