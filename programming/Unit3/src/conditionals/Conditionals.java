package conditionals;
import java.util.Scanner;

public class Conditionals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("How old are you?");
		int age = keyboard.nextInt();
		
		if (age>=18) {
			System.out.println("You are legal age");
		}
		else {
			System.out.println("You are very small, enjoy while you can.");
		}
		
	}

}
