/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 */
public class Day27_MaximalSquare {
    //3ms beats 97.99%
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '0') continue;
                    if (Math.min(matrix.length - i, matrix[0].length - j) + 1 <= max) continue;
                    int count = 1;
                    for (int k = 1; k < Math.min(matrix.length - i, matrix[0].length - j); k++) {
                        boolean flag = true;
                        for (int z = i; z <= i + k; z++) {
                            if (matrix[z][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) break;
                        for (int z = j; z < j + k; z++) {
                            if (matrix[i + k][z] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            count++;
                        else break;
                    }
                    if (count > max) {
                        max = count;
                    }

                }
            }
            return (int) Math.pow(max, 2);
        }
    }
}
