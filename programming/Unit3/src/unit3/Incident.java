package unit3;

import java.util.Scanner;

public class Incident {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Name: ");
		String name = keyboard.nextLine();
		System.out.println("Age: ");
		int age = keyboard.nextInt();
		System.out.println("Your name is " + name + " and you are " + age + " y/o.");

		/*If we first ask for the integer and then we ask for a string, an extra nextLine(), as Java fails to consume the Enter,
		also called "Carriage Return" in functions like nextDouble(), nextLong(), nextInt()...etc.
		
		FOR EXAMPLE
	
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Age: ");
		int age = keyboard.nextInt();
		
		keyboard.nextLine();
		
		System.out.println("Name: ");
		String name = keyboard.nextLine();
		
		System.out.println("Your name is " + name + " and you are " + age + " y/o.");*/
		
	}

}
