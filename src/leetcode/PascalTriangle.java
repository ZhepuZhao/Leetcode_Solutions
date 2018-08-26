package leetcode;

import java.util.*;
public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(5);
		
	}
    public static List<List<Integer>> generate(int numRows) {
        /*
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) return triangle;
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        if (numRows == 1) return triangle;
        triangle.add(new ArrayList<Integer>());
        triangle.get(1).add(1);
        triangle.get(1).add(1);
        // List<Integer> temp = new ArrayList<Integer>();
        for (int i = 2; i < numRows; i++){
            triangle.add(new ArrayList<Integer>());
            List<Integer> current = triangle.get(triangle.size()-1);
            List<Integer> previous = triangle.get(triangle.size()-2);
            current.add(1);
            for (int j = 1; j < triangle.get(triangle.size()-2).size(); j++){
                current.add(previous.get(j) + previous.get(j-1));
            }
            current.add(1);
        }
        return triangle;*/
        
        // another better solution
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++){
            row.add(0, 1); // add 1 to the position 0
            for(int j=1;j<row.size()-1;j++){ // 
                row.set(j, row.get(j)+row.get(j+1));
            }
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;        
    }

}
