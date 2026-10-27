package storeBuyerCalculator;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the amount of product units that you want to order: ");
		int units = keyboard.nextInt();
		System.out.println("Enter the price of the product that you want to order: ");
		double price = keyboard.nextDouble();
		double subtotal = units * price;
		final double VAT = 0.21;
		double total = subtotal * VAT;
		System.out.println("The total amount (in €) that this will cost you is = " + total + "€");
	
	}

}
