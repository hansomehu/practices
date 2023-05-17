package interview150.matrix;

public class S289_GameOfLife {
    /**
     * https://leetcode.cn/problems/game-of-life/
     * 要点就是为需要流转的情况创建新的状态，当遇到这些新状态的时候就能够知道它曾经是哪个状态
     * 0 dead
     * 1 live
     * -1 was live but now dead
     * 2 was dead but now live
     */
    public int[][] solution(int[][] cells){
        int[] neighbours = {0, 1, -1};

        int rows = cells.length;
        int columns = cells[0].length;
        for (int row = 0; row < columns; row++) {
            for (int col = 0; col < rows; col++) {

                // check neighbours
                int liveNeighbours = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (!(m == 0 && n == 0)) {
                            int neighbourRow = row + neighbours[m];
                            int neighbourCol = col + neighbours[n];

                            if ((neighbourRow < rows && neighbourRow >= 0)
                                    && (neighbourCol < columns && neighbourCol >=0)
                                    && Math.abs(cells[neighbourRow][neighbourCol]) == 1) {
                                liveNeighbours += 1;
                            }
                        }
                    }
                }

                // compute and state transfer
                if (cells[row][col] == 0 && liveNeighbours == 3) {
                    cells[row][col] = 2;
                }
                // todo other rules ...

            }
        }

        // final traverse to update all cells into correct formal state
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j] > 0) {
                    cells[i][j] = 1;
                } else {
                    cells[i][j] = 0;
                }
            }

        }

        return cells;
    }
}
