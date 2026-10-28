package conditionals;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("1. Sign in");
		System.out.println("2. Sign out");
		System.out.println("3. Query");
		
		int option = keyboard.nextInt();
		switch (option) {
		case 1:
			System.out.println("Sign in selected");
			break;
		case 2:
			System.out.println("Sign out selected");
			break;
		case 3:
			System.out.println("Selected query");
			break;
		default:
			System.out.println("Incorrect option");
		
		}

	}
	
}
