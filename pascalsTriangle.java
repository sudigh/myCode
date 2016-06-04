public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pTriangle = new ArrayList<>();
        if (numRows == 0) {
            return pTriangle;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        pTriangle.add(row1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prevRow = pTriangle.get(i-1);
            for (int j = 0; j < i-1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j+1));
            }
            row.add(1);
            pTriangle.add(row);
        }
        return pTriangle;
    }
}
