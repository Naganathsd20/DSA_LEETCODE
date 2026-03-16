import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set = new TreeSet<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                set.add(grid[i][j]);

                for(int k = 1; i-k >= 0 && i+k < m && j-k >= 0 && j+k < n; k++) {
                    int sum = 0;

                    for(int t = 0; t < k; t++) {
                        sum += grid[i-k+t][j+t];
                        sum += grid[i+t][j+k-t];
                        sum += grid[i+k-t][j-t];
                        sum += grid[i-t][j-k+t];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] result = new int[size];

        int i = 0;
        while(i < size) {
            result[i++] = set.pollLast();
        }

        return result;
    }
}