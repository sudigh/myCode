/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
REF : First mark the row and column of the matrix in which there are elements with value 0 by setting the zeroth row and jth 
column element to 0 and zeroth column and ith row element to 0. Set firstR to true if there are elements with value 0 in the 
first row and firstC to 0 if there are elements with value 0 in the first column. Then set all the elements of rows and columns 
that are marked 0  as 0. Then if firstR is true set all zeroth row elements to 0 and if firstC is true then all first column 
elements to 0.
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        boolean firstR = false, firstC = false;
        for (int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstR = true;
                    if (j == 0) firstC = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            } 
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstR == true) {
            for (int i = 0; i < c; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstC == true) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
