package dataStructures;

public class Matrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int[][] matrix = {
                {1, 2, 3, 8},
                {4, 5, 6, 9},
                {2, 4, 4, 3}
            };
		
		System.out.println("matrix[1][3] = " + matrix[1][3]); 
		
		int rows = matrix.length;
		
		int columns = matrix[0].length;
		
		System.out.println("Rows = " + rows); 
		
		System.out.println("Columns = " + columns); 
		
		for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[row].length; col++) {
        	System.out.print(matrix[row][col] + "\t");
        	}
        System.out.println();
		}

	}
	
}
