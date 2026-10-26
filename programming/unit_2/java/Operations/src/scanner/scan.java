package scanner;
import java.util.Scanner;

public class scan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Age: ");
		int age = keyboard.nextInt();
		System.out.println("You are " + age + " years old");
		System.out.println("Height (cm): ");
		double height = keyboard.nextDouble();
		System.out.println("You are " + height + "cm tall");
		
	}

}
