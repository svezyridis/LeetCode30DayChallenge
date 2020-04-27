import java.util.List;

/**
 * (This problem is an interactive problem.)
 * <p>
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * Example 4:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 */
public class Day21_LeftmostColumnWithAtLeastAOne {

    // This is the BinaryMatrix's API interface.
    // You should not implement it, or speculate about its implementation
    interface BinaryMatrix {
        public int get(int x, int y);

        public List<Integer> dimensions();
    }

    //0ms answer
    class Solution {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> dimensions = binaryMatrix.dimensions();
            int n = dimensions.get(0);
            int m = dimensions.get(1);

            int lastIndex = -1;
            for (int i = 0; i < n; i++) {
                int lo = 0;
                int hi = m - 1;
                while (hi >= lo) {
                    int mid = lo + (hi - lo) / 2;
                    int x = binaryMatrix.get(i, mid);
                    if (x == 0)
                        lo = mid + 1;
                    if (x == 1) {
                        hi = mid - 1;
                        if (mid < lastIndex || lastIndex == -1)
                            lastIndex = mid;
                    }
                }
            }
            return lastIndex;
        }
    }
}
