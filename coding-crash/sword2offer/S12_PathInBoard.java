package sword2offer;

import java.util.*;

public class S12_PathInBoard {
    public static void main(String[] args) {

        /**
         *  给定一个 m x n 二维字符网格 board 和一个字符串单词 word
         *  如果 word 存在于网格中，返回 true
         *  否则，返回 false
         *
         *  思路：回溯算法，从遍历二维数组的两个for循环切进去，然后在check中内嵌check对该位置的上下左右进行遍历
         */


    }

    public boolean exist(char[][] board, String word){
        Vector<Integer> vector = new Vector<>();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        NavigableSet<Integer> navigableSet = treeSet.descendingSet();


        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                // entry
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) return true;

            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k ){
        if (board[i][j] != word.charAt(k)){
            return false;
        }else if (k == word.length() - 1)
            return true;

        // proceed only under condition "board[i][j] == word.charAt(k)"
        visited[i][j] = true;
        // right - left - down - up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        // 从i、j的上下左右进行遍历  traverse in r-l-d-u four directions
        for (int[] dir : directions){
            // 能否向上下左右遍历存在一些控制条件 the new-i and new-j need to be within [w,h]
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if (!visited[newi][newj]){
                    boolean flag = check(board, visited, newi, newj, word, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }


        }
        // visited is a conception only for a single round of check
        visited[i][j] = false;
        return result;

    }
}
