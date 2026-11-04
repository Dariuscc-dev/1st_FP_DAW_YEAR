package unit4;
import java.util.Random;

public class CharClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char character = 'A';
		
		System.out.println("Is a number? = " + Character.isDigit(character));
		
		System.out.println("Is lower case? = " + Character.isLowerCase(character));
		
		System.out.println("Let´s turn it into lower case = " + Character.toLowerCase(character));
		
		Random random = new Random();
		int r = random.nextInt();
		double d = random.nextDouble();
		
		System.out.println(r);
		
		System.out.println(d);
		
		System.out.println(r + d);
		
		int dice = random.nextInt(7); //Between 0 and lower than 7
		System.out.println(dice);
		
		int numberr = random.nextInt(31) + 50; //Between 50 and 80
		System.out.println(numberr);
		
	}

}
