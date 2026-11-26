package modularProgramming;
import java.util.Scanner;

public class CaseStudyFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Parse 3 numbers that you´d like to make an average of =");
		
		Scanner keyboard = new Scanner (System.in);
		double a = keyboard.nextDouble();
		double b = keyboard.nextDouble();
		double c = keyboard.nextDouble();
		
		double averageOfThese3 = averageOfThese3(a,b,c);
		System.out.println("The average of the three numbers parsed is = " + averageOfThese3);
		
		keyboard.nextLine();
		
		System.out.println("And finally, let me illuminate you with how smart I am, by repeating your name inside a phrase. Your name is?... (please say it to me)");
		
		String name = keyboard.nextLine();
		parseName(name);
		
	}

	// Function to ask for 3 numbers that we want to calculate the average of.
	
	public static double averageOfThese3(double a, double b, double c) {
		return ((a + b + c)/3);
	}
	
	public static void parseName(String name) {
		System.out.println("Hello " + name + ", how are you?");
	}
	
}
