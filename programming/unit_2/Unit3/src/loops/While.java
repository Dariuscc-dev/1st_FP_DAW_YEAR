package loops;

public class While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 10;
		
		while (i>=1) {
			System.out.println("The value of i is " + i);
		
			i--;
			
		}
		
		// -----------------------------------------------------------------------------------------------------------------------------------
		
		int j = 0;
		
		do {
			System.out.println("The value of j is " + j);
			j++;
		}
		
		while (j <= 10); // The do-while loop will execute itself at least one time, which differs from the "simple while"/while-do loop.
		
	}

}
