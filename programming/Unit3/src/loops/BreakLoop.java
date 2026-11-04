package loops;

public class BreakLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int row = 0; row < 10; row++) { 
			if (row == 3) {
				break;
			}
				System.out.println(row + " row.");
		}
		
	System.out.println("After the loop.");
		
	}
		
}
