package store;

public class Box {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final double VAT = 0.21;
		double price = 100.0;
		int units = 2;
		double subtotal = price * units;
		double total = subtotal + subtotal * VAT;
		boolean over200 = total > 200;
		System.out.println("Total: " + total);
		System.out.println("¿Over 200? " + over200);
		
	}

}
